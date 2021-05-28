package cf.gofo;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Playground Owner class inherits from User class
 * @author 20180142 - 20180251
 */
public class PlaygroundOwner extends User {
    /**
     * Array of playgrounds that holds owned playgrounds
     */
    private ArrayList<Playground> playgrounds = new ArrayList<Playground>();
    /**
     * The playground owner's E-wallet
     */
    private eWallet wallet = new eWallet();
    /**
     * Numebr of owned playgrounds
     */
    private int playgroundsNum = 0;

    /**
     * Adds a playground to owned playgrounds array
     */
    public void addPlayground(){
        Playground newplayground = new Playground();
        playgrounds.add(newplayground);
        playgroundsNum++;
    }
    /**
     * Removes a playground from owned playgrounds array
     */
    public void removePlayground(){
        System.out.print("Please enter Playground: ");
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        System.out.println("Searching for playground...");
        for(int i = 0;i<playgrounds.size();i++){
            if(playgrounds.get(i).getName().equals(userinput)){
                System.out.println("Playground found, deleting...");
                playgrounds.remove(i);
                System.out.println("Deleted successfully");
                break;
            }
        }
    }

    /**
     * Receive a payment from a player or another owner
     * @param amount
     */
    public void receivePayment(float amount){
        wallet.addBalance(amount);
    }

    /**
     * View playground owner's E-wallet Balance
     */
    public void viewBalance(){
        System.out.println("Current balance: "+ wallet.getBalance());
    }

    /**
     * View owned playgrounds
     */
    public void viewPlaygrounds(){
        for(int i=0;i<playgrounds.size();i++){
            System.out.println("==============================");
            System.out.print((i+1)+"- ");
            playgrounds.get(i).print();
            System.out.println("==============================");
        }
        if(playgrounds.size()==0){
            System.out.println("You have no playgrounds!");
        }
    }
    /**
     * View owned playgrounds for players
     */
    public void viewPlaygroundsForPlayer(){
        for(int i=0;i<playgrounds.size();i++){
            if(playgrounds.get(i).isActive()&&playgrounds.get(i).isApproved()){
                System.out.println("==============================");
                System.out.print((i+1)+"- ");
                playgrounds.get(i).printForListing();
                System.out.println("==============================");
            }
        }
    }

    /**
     * View booked timeslots
     */
    public void viewBookings(){
        for(int i =0;i<playgrounds.size();i++){
            System.out.println("Playground name: "+ playgrounds.get(i).getName());
            playgrounds.get(i).viewBooked();
        }
    }

    /**
     * View all timeslots available for all playgrounds
     */
    public void viewTimeslots(){
        for(int i =0;i<playgrounds.size();i++){
            System.out.println("Playground name: "+ playgrounds.get(i).getName());
            playgrounds.get(i).viewTimeslot();
        }
    }

    /**
     * filters playgrounds by cities
     */
    public void filterCity(){
        System.out.println("Please enter city: ");
        Scanner in = new Scanner(System.in);
        String city = in.nextLine();
        for(int i=0;i<playgroundsNum;i++){
            if(playgrounds.get(i).getLocation().getCity().equals(city)){
                playgrounds.get(i).print();
                System.out.println("==============");
            }
        }
    }

    /**
     * filters playgrounds by time
     */
    public void filterTime(){
        System.out.println("Please enter Day: ");
        Scanner in = new Scanner(System.in);
        String day = in.nextLine();
        System.out.println("Please enter Time: ");
        int time = in.nextInt();
        for(int i=0;i<playgroundsNum;i++){
            TimeSlot t =playgrounds.get(i).searchSlot(day, time);
            if(t!=null){
                playgrounds.get(i).print();
                System.out.println("==============");
            }
        }
    }

    /**
     * Search for a playground
     * @param name playground name
     * @return playground if found or null otherwise
     */
    public Playground searchName(String name){
        for (Playground playground : playgrounds) {
            if (playground.getName().equals(name)) {
                return playground;
            }
        }
        return null;
    }

    /**
     * Get number of owned playgrounds
     * @return number of owned playgrounds
     */
    public int getPlaygroundsNum() {
        return playgroundsNum;
    }
}
