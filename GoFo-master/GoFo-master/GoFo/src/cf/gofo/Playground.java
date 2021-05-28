package cf.gofo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Playground class (holds playground information)
 * @author 20180142 - 20180251
 */
public class Playground {
    /**
     * Playground name
     */
    private String name;
    /**
     * Playground size
     */
    private int size;
    /**
     * Playground price per hour
     */
    private float priceperhour;
    /**
     * Playground cancellation period
     */
    private int cancellationperiod;
    /**
     * Playground approval status
     */
    private boolean approved;
    /**
     * Playground activation status (true by default)
     */
    private boolean active = true;
    /**
     * Playground Location
     */
    private Location location;
    /**
     * Array of complaints against this playground
     */
    private ArrayList<Complaint> complaints = new ArrayList<Complaint>();
    /**
     * Array if timeslots
     */
    private ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();

    /**
     * Creates a playground
     */
    public Playground() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter playground name: ");
        String newName = sc.nextLine();
        setName(newName);
        System.out.println("Enter playground size: ");
        int newSize=sc.nextInt();
        setSize(newSize);
        System.out.println("Enter playground price per hour: ");
        float newPPH=sc.nextFloat();
        setPriceperhour(newPPH);
        System.out.println("Enter playground cancellation period: ");
        int newCancelP=sc.nextInt();
        setCancellationperiod(newCancelP);
        location= new Location(this);
        for(int i=1;i<8;i++){
            switch(i){
                case 1: {
                    System.out.println("Enter opening hours on Saturday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Saturday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter opening hours on Sunday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Sunday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter opening hours on Monday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Monday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter opening hours on Tuesday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Tuesday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter opening hours on Wednesday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Saturday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter opening hours on Thursday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Thursday", this);
                        timeSlots.add(newTimeslot);
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter opening hours on Friday:");
                    int hours = sc.nextInt();
                    System.out.println("Enter opening time[24 hour clock]: ");
                    int openTime = sc.nextInt();
                    for (int j = openTime; j < openTime + hours; j++) {
                        TimeSlot newTimeslot = new TimeSlot(j, "Friday", this);
                        timeSlots.add(newTimeslot);

                    }
                    break;
                }
                default:{
                    System.out.println("Please enter a valid answer...");
                    break;
                }
            }
        }
    }
    public void viewBooked(){
        for(int i =0;i<timeSlots.size();i++){
            if(timeSlots.get(i).isBooked()){
                System.out.println("==============================");
                timeSlots.get(i).print();
                System.out.println("==============================");
            }
        }
    }

    /**
     * View all playground timeslots
     */
    public void viewTimeslot(){
        for(int i =0;i<timeSlots.size();i++){
            System.out.println("Time slot number "+(i+1));
            timeSlots.get(i).print();
        }
    }

    /**
     * Prints playground information for admin and owner
     */
    public void print(){
        System.out.println("Playground Name: "+name);
        System.out.println("Playground Size: "+size);
        System.out.println("Playground Price/h: "+priceperhour+" EGP/h");
        System.out.println("Cancellation period: "+cancellationperiod);
        if(approved){
            System.out.println("The playground is approved by admin");
        }else {
            System.out.println("Warning: The playground needs to be approved!");
        }
        if(active){
            System.out.println("Active?: Yes");
        }else {
            System.out.println("Active?: No");
        }
    }

    /**
     * Prints playground information for player
     */
    public void printForListing(){
        System.out.println("Playground Name: "+name);
        System.out.println("Playground Size: "+size);
        System.out.println("Playground Price/h: "+priceperhour+" EGP/h");
        System.out.println("Cancellation period: "+cancellationperiod);
    }

    /**
     * Search for a timeslot in a playground
     * @param day day of timeslot
     * @param time time of timeslot
     * @return timeslot if found or null if not found
     */
    public TimeSlot searchSlot(String day, int time){
        for (TimeSlot timeSlot : timeSlots) {
            if (timeSlot.getBegin() == time && timeSlot.getDay().equals(day)) {
                return timeSlot;
            }
        }
        return null;
    }

    /**
     * Get playground Name
     * @return playground name
     */
    public String getName() {
        return name;
    }

    /**
     * Get playground Location
     * @return playground location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Get playground size
     * @return playground size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get playground price per hour
     * @return playground price per hour
     */
    public float getPriceperhour() {
        return priceperhour;
    }

    /**
     * Get playground cancellation period
     * @return playground cancellation period
     */
    public int getCancellationperiod() {
        return cancellationperiod;
    }

    /**
     * Checks whether the playground is approved or not
     * @return Approval status
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Checks whether the playground is active or not
     * @return activation status
     */
    public boolean isActive() {
        return active;
    }

    /**
     * changes playground name
     * @param name new playground name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * changes playground size
     * @param size new playground size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * changes playground price per hour
     * @param priceperhour new price per hour
     */
    public void setPriceperhour(float priceperhour) {
        this.priceperhour = priceperhour;
    }

    /**
     * changes playground cancellation period
     * @param cancellationperiod new cancellation period
     */
    public void setCancellationperiod(int cancellationperiod) {
        this.cancellationperiod = cancellationperiod;
    }

    /**
     * changes approval status
     * @param approved new approval status
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * changes active status
     * @param active active status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Adds a new complaint to complaints array
     * @param newComplaint new complaint
     */
    public void addComplaints(Complaint newComplaint) {
        complaints.add(newComplaint);
    }

    /**
     * Adds a new timeslot to timeslot array
     * @param newTimeSlot new timeslot
     */
    public void addTimeSlot(TimeSlot newTimeSlot) {
        timeSlots.add(newTimeSlot);
    }
}
