package cf.gofo;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Where the program starts
 * @author 20180142 - 20180251 - 20180294
 */
public class Main {
    /**
     * Array of all program users
     */
    static ArrayList<User> users = new ArrayList<User>();
    /**
     * Program super admin
     */
    static Admin superAdmin = new Admin("admin");

    /**
     * Function for Playground owner options
     * @param owner the owner who just logged in
     */
    public static void OwnerUI(PlaygroundOwner owner){
        Scanner in = new Scanner(System.in);
        boolean stay = true;
        while(stay){
            System.out.println("Welcome in Owner menu!");
            System.out.println("1. Add playground\n" +
                    "2. Remove playground\n" +
                    "3. View all playgrounds\n" +
                    "4. View bookings\n" +
                    "5. View all time slots\n" +
                    "6. View balance\n" +
                    "7. exit\n");
            String userInput = in.nextLine();
            switch (userInput){
                case "1":{
                    owner.addPlayground();
                    break;
                }
                case "2":{
                    owner.removePlayground();
                    break;
                }
                case "3":{
                    owner.viewPlaygrounds();
                    break;
                }
                case "4":{
                    owner.viewBookings();
                    break;
                }
                case "5":{
                    owner.viewTimeslots();
                    break;
                }
                case "6" :{
                    owner.viewBalance();
                    break;
                }
                case "7":{
                    stay = false;
                    break;
                }
                default:{
                    System.out.println("Please enter a valid answer!");
                }
            }
        }
    }

    /**
     * Function for Player options
     * @param player the player who just logged in
     */
    public static void PlayerUI(Player player){
        Scanner in = new Scanner(System.in);
        boolean stay = true;
        while(stay){
            System.out.println("Welcome in Player menu!");
            System.out.println("1. Book a playground\n" +
                    "2. View bookings\n" +
                    "3. Cancel booking\n" +
                    "4. Create Team\n"+
                    "5. View Team\n"+
                    "6. Add team member\n" +
                    "7. Charge eWallet\n" +
                    "8. View balance" +
                    "9. exit\n");
            String userInput = in.nextLine();
            switch (userInput){
                case "1":{
                    boolean stop = false;
                    while (!stop){
                        System.out.println("1-View all playgrounds\n"+
                                "2- Filter by city\n" +
                                "3- Filter by time\n"+
                                "4- Select playground\n" +
                                "5- Back");
                        String userAns = in.nextLine();
                        switch (userAns){
                            case "1":{
                                for (User user : users) {
                                    if(user.getRole().equals("owner")){
                                        ((PlaygroundOwner) user).viewPlaygroundsForPlayer();
                                    }
                                    System.out.println("======================");
                                }
                                break;
                            }
                            case "2":{
                                for (User user : users) {
                                    if(user.getRole().equals("owner")){
                                        ((PlaygroundOwner) user).filterCity();
                                    }
                                    System.out.println("======================");
                                }
                                break;
                            }
                            case "3":{
                                for (User user : users) {
                                    if(user.getRole().equals("owner")){
                                        ((PlaygroundOwner) user).filterTime();
                                    }
                                    System.out.println("======================");
                                }
                                break;
                            }
                            case "4":{
                                System.out.println("Please enter playground name: ");
                                String name = in.nextLine();
                                Playground toBook = null;
                                PlaygroundOwner owner = null;
                                for(User user: users){
                                    if(user.getRole().equals("owner") && ((PlaygroundOwner) user).searchName(name) != null){
                                        toBook = ((PlaygroundOwner) user).searchName(name);
                                        owner = (PlaygroundOwner) user;
                                        break;
                                    }
                                }
                                if(toBook == null){
                                    System.out.println("Playground does not exist!");
                                }
                                else{
                                    toBook.viewTimeslot();
                                    System.out.println("Please enter day: ");
                                    String day = in.nextLine();
                                    System.out.println("Please enter time: ");
                                    int time = in.nextInt();
                                    in.nextLine();
                                    TimeSlot timeSlot = toBook.searchSlot(day, time);
                                    if(timeSlot == null){
                                        System.out.println("Time slot not found");
                                    }
                                    else{
                                        player.bookPlayground(timeSlot, toBook, owner);
                                    }
                                }
                                stop = false;
                                break;
                            }
                            case "5":{
                                stop = true;
                                break;
                            }
                            default:{
                                System.out.println("Please enter a valid answer!");
                            }
                        }
                    }
                    break;
                }
                case "2":{
                    player.viewBookings();
                    break;
                }
                case "3":{
                    System.out.println("Enter playground name");
                    String name = in.nextLine();
                    Playground toCancel = null;
                    for(User user: users){
                        if(((PlaygroundOwner) user).searchName(name) != null){
                            toCancel = ((PlaygroundOwner) user).searchName(name);
                            break;
                        }
                    }
                    if(toCancel == null){
                        System.out.println("Playground does not exist!");
                    }
                    else{
                        System.out.println("Please enter day: ");
                        String day = in.nextLine();
                        System.out.println("Please enter time: ");
                        int time = in.nextInt();
                        TimeSlot timeSlot = toCancel.searchSlot(day, time);
                        player.cancelBooking(timeSlot);
                    }
                    break;
                }
                case "4":{ // Create Team
                    if(player.getTeamName().equals("")){
                        System.out.print("Please enter team name: ");
                        String name=in.nextLine();
                        player.setTeamName(name);
                        System.out.println("Team was created,try adding members to it.");
                    }else{
                        System.out.println("You already have a team named "+player.getTeamName()+".");
                    }
                    break;
                }
                case "5":{ // View team
                    player.viewTeam();
                    break;
                }
                case "6":{ // Add team member
                    if(player.getTeamName().equals("")){
                        System.out.println("Please create a team first to add a member");
                    }else {
                        String email;
                        boolean validated=false;
                        while(!validated){
                            System.out.println("Please enter player email to send invitation:");
                            email=in.nextLine();
                            if(player.validEmail(email)){
                                validated=true;
                                System.out.println("Invitation sent successfully!");
                            }else{
                                System.out.println("Please enter a valid email address!");
                            }
                        }
                    }
                    break;
                }
                case "7":{
                    System.out.println("Enter eWallet credentials: ");
                    System.out.println("Account number: ");
                    String dummyNumber = in.nextLine();
                    System.out.println("password");
                    String dummyPassword = in.nextLine();
                    System.out.println("Enter charge amount: ");
                    float amount = in.nextFloat();
                    System.out.println("Enter charge code: ");
                    String dummyCode = in.nextLine();
                    in.nextLine();
                    player.charge(amount);
                    break;
                }
                case "8": {
                    player.viewBalance();
                    break;
                }
                case "9": {
                    stay = false;
                    break;
                }
                default:{
                    System.out.println("Please enter a valid answer!");
                }
            }
        }
    }

    /**
     * Function for Admin options
     * @param admin the admin who just logged in
     */
    public static void AdminUI(Admin admin){
        Scanner in = new Scanner(System.in);
        boolean stay = true;
        while(stay){
            System.out.println("Welcome in Admin menu!");
            System.out.println("1. Approve playground\n" +
                    "2. Activate playground\n" +
                    "3. Suspend playground\n" +
                    "4. Delete playground\n" +
                    "5. Add a new admin\n" +
                    "6. exit\n");
            String userInput = in.nextLine();
            switch (userInput){
                case "1":{
                    System.out.println("Please enter playground name: ");
                    Playground toApprove = null;
                    String name = in.nextLine();
                    for(User user: users){
                        if(user.getRole().equals("owner") && ((PlaygroundOwner) user).searchName(name) != null){
                            toApprove = ((PlaygroundOwner) user).searchName(name);
                            break;
                        }
                    }
                    if(toApprove == null){
                        System.out.println("Playground does not exist!");
                    }
                    else{
                        admin.approvePlayground(toApprove);
                    }
                    break;
                }
                case "2":{
                    System.out.println("Please enter playground name: ");
                    Playground toActivate = null;
                    String name = in.nextLine();
                    for(User user: users){
                        if(user.getRole().equals("owner") && ((PlaygroundOwner) user).searchName(name) != null){
                            toActivate = ((PlaygroundOwner) user).searchName(name);
                            break;
                        }
                    }
                    if(toActivate == null){
                        System.out.println("Playground does not exist!");
                    }
                    else{
                        admin.activatePlayground(toActivate);
                    }
                    break;
                }
                case "3":{
                    System.out.println("Please enter playground name: ");
                    Playground toSuspend = null;
                    String name = in.nextLine();
                    for(User user: users){
                        if(((PlaygroundOwner) user).searchName(name) != null){
                            toSuspend = ((PlaygroundOwner) user).searchName(name);
                            break;
                        }
                    }
                    if(toSuspend == null){
                        System.out.println("Playground does not exist!");
                    }
                    else{
                        admin.suspendPlayground(toSuspend);
                    }
                    break;
                }
                case "4":{
                    System.out.println("Please enter Playground owner name: ");
                    String name = in.nextLine();
                    for(User user: users){
                        if(((PlaygroundOwner) user).getName().equals(name)){
                            ((PlaygroundOwner) user).removePlayground();
                        }
                    }
                    break;
                }
                case "5":{
                    Admin newAdmin = new Admin();
                    newAdmin.setRole("admin");
                    users.add(newAdmin);
                }
                case "6":{
                    stay = false;
                    break;
                }
                default:{
                    System.out.println("Please enter a valid answer!");
                }
            }
        }
    }

    /**
     * Program starts here
     * @param args
     */
    public static void main(String[] args) {
        int currentUser=-1;
        users.add(superAdmin);
        Scanner in = new Scanner(System.in);
        boolean stay = true;
        while (stay) {
            System.out.println("Welcome in Gofo!");
            System.out.println("1. create profile\n" +
                    "2. login\n" +
                    "3. Administrator\n" +
                    "4. exit\n");
            String choice = in.nextLine();
            //in.nextLine();
            switch (choice) {
                case "1": {
                    String role;
                    System.out.println("Are you:\n -player     -owner :");
                    role=in.nextLine();
                    if(role.equalsIgnoreCase("player"))
                    {
                        Player adder = new Player();
                        users.add(adder);
                        adder.setRole("player");
                    }
                    else if(role.equalsIgnoreCase("owner"))
                    {
                        PlaygroundOwner adder = new PlaygroundOwner();
                        users.add(adder);
                        adder.setRole("owner");
                    }
                    else
                    {
                        System.out.println("invalid input!");
                    }
                    break;
                }
                case "2": {
                    String name,pass;
                    System.out.println("enter name:");
                    name=in.nextLine();
                    System.out.println("enter password:");
                    pass=in.nextLine();
                    for(int i=0;i<users.size();i++)
                    {
                        if(name.contentEquals(users.get(i).getName()) && pass.contentEquals(users.get(i).getPassword()))
                        {
                            currentUser=i;
                        }
                    }
                    if(currentUser==-1)
                    {
                        System.out.println("invalid username or password!");
                    }
                    else
                    {
                        System.out.println("welcome " + users.get(currentUser).getName());
                        if(users.get(currentUser).getRole().equals("player")){
                            PlayerUI((Player) users.get(currentUser));
                        }
                        else{
                            OwnerUI((PlaygroundOwner) users.get(currentUser));
                        }
                    }
                    currentUser = -1;
                    break;
                }
                case "3": {
                    String name,pass;
                    System.out.println("enter name:");
                    name=in.nextLine();
                    System.out.println("enter password:");
                    pass=in.nextLine();
                    for(int i=0;i<users.size();i++)
                    {
                        if(name.contentEquals(users.get(i).getName()) && pass.contentEquals(users.get(i).getPassword()))
                        {
                            currentUser=i;
                        }
                    }
                    if(currentUser==-1)
                    {
                        System.out.println("invalid username or password!");
                    }
                    else
                    {
                        System.out.println("welcome " + users.get(currentUser).getName());
                        AdminUI((Admin) users.get(currentUser));
                    }
                    break;
                }

                case "4": {
                    stay = false;
                    break;
                }

                default: {
                    System.out.println("invalid input");
                    break;
                }
            }
        }
        in.close();
        System.exit(0);
    }
}
