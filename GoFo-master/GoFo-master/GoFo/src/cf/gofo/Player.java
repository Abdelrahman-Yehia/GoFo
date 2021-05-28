package cf.gofo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * Player class inherits from User class
 * @author 20180142-20180251
 */
public class Player extends User {
    /**
     * Array of players holding team members
     */
	private ArrayList<Player> team = new ArrayList<Player>();
    /**
     * Team Name
     */
    private String teamName = "";
    /**
     * Array of time slots holding booked time slots
     */
    private ArrayList<TimeSlot> bookings = new ArrayList<TimeSlot>();
    /**
     * Array of complaints holding complaints issued by the player
     */
    private ArrayList<Complaint> complaints = new ArrayList<Complaint>();
    /**
     * The player's E-wallet
     */
    private eWallet wallet = new eWallet();

    /**
     * Book an available playground
     * @param timeSlot timeslot in the playground to be booked
     * @param toBook playground to be booked
     * @param owner playground owner to transfer payment to
     */
    public void bookPlayground(TimeSlot timeSlot, Playground toBook, PlaygroundOwner owner){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter eWallet credentials: ");
        System.out.println("Account number: ");
        String dummyNumber = in.nextLine();
        System.out.println("password");
        String dummyPassword = in.nextLine();
        System.out.println("Total amount: " + toBook.getPriceperhour() +"LE\n" +
                "1- Confirm payment\n"+
                "2- Cancel\n");
        String choice = in.nextLine();
        switch (choice){
            case "1":{
                if(wallet.removeBalance(toBook.getPriceperhour())){
                    timeSlot.setBooked(true);
                    timeSlot.setBookedby(this);
                    bookings.add(timeSlot);
                    owner.receivePayment(toBook.getPriceperhour());
                    System.out.println("Payment completed successfully!\nPlayground booked successfully!");
                }
                break;
            }
            case"2":{
                System.out.println("Process canceled!");
                break;
            }
            default:{
                System.out.println("Please enter a valid input!");
            }
        }
    }

    /**
     * Cancel a booking
     * @param toCancel the time slot to cancel
     */
    public void cancelBooking(TimeSlot toCancel) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookedin().getName().equals(toCancel.getBookedin().getName()) && bookings.get(i).getBegin() == toCancel.getBegin()) {
                if (toCancel.getBookedin().getCancellationperiod() > 0) {
                    bookings.remove(i);
                    System.out.println("Booking canceled successfully!\n");
                }
                else{
                    System.out.println("WARNING: If you cancel your booking now you will not be refunded since the cancellation period has ended!\nDo you want to cancel anyway[y:yes, n:no]: ");
                    Scanner in = new Scanner(System.in);
                    String userAns = in.nextLine();
                    if(userAns.equals("y")){
                        bookings.remove(i);
                        System.out.println("Booking canceled successfully!\n");
                    }
                }
                break;
            }
        }
    }

    /**
     * View bookings made by the player
     */
    public void viewBookings(){
        for(int i=0;i<bookings.size();i++){
            System.out.println("Booking number"+(i+1)+": ");
            bookings.get(i).print();
        }
    }

    /**
     * View players team members
     */
    public void viewTeam(){
        if(teamName.equals("")){
            System.out.println("Please create a team first.");
        }else if(team.size()==0){
            System.out.println("Your team: "+teamName);
            System.out.println("No team members found...");
        }else{
            System.out.println("Your team: "+teamName);
            for(int i=0;i<team.size();i++){
                System.out.println("["+(i+1)+"]\tName: "+team.get(i).name);
                System.out.println("\tEmail: "+team.get(i).email);
            }
        }
    }

    /**
     * Charge players E-wallet
     * @param amount amount to be charged
     */
    public void charge(float amount){
        wallet.addBalance(amount);
        System.out.println("Amount charged successfully!\n Current balance: "+ wallet.getBalance() +"LE");
    }

    /**
     * View E-wallet Balance
     */
    public void viewBalance(){
        System.out.println("Current balance: "+ wallet.getBalance());
    }

    /**
     *
     * @return player's team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Changes player's team name
     * @param teamName new team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
