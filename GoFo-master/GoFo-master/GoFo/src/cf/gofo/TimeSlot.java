package cf.gofo;

/**
 * Timeslot class for playgrounds and players
 * @author 20180142 - 20180251 - 20180294
 */
public class TimeSlot {
    /**
     * The begin time for the timeslot
     */
    private int begin;
    /**
     * Day of timeslot
     */
    private String day;
    /**
     * Booked status
     */
    private boolean booked;
    /**
     * PLayer who booked the timeslot
     */
    private Player bookedby;
    /**
     * Playground where the timeslot is
     */
    private Playground bookedin;

    /**
     * Creates a Timeslot
     * @param begin begin time
     * @param day day
     * @param bookedin playground where the timeslot is
     */
    public TimeSlot(int begin, String day, Playground bookedin) {
        this.begin = begin;
        this.day = day;
        this.bookedin = bookedin;
    }

    /**
     * Get begin time
     * @return begin time
     */
    public int getBegin() {
        return begin;
    }

    /**
     * Get timeslot day
     * @return timeslot day
     */
    public String getDay() {
        return day;
    }

    /**
     * Checks whether the timeslot is booked or not
     * @return booked status
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * Get player who booked the timeslot
     * @return player who booked the timeslot
     */
    public Player getBookedby() {
        return bookedby;
    }

    /**
     * Get Playground where the timeslot is
     * @return Playground where the timeslot is
     */
    public Playground getBookedin() {
        return bookedin;
    }

    /**
     * Changes begin time
     * @param begin new begin time
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * Changes timeslot day
     * @param day new day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Changes booked status
     * @param booked new boooked status
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * Changes the player who booked the timeslot
     * @param bookedby new player
     */
    public void setBookedby(Player bookedby) {
        this.bookedby = bookedby;
    }

    /**
     * Changes the Playground where the timeslot is
     * @param bookedin new playground
     */
    public void setBookedin(Playground bookedin) {
        this.bookedin = bookedin;
    }

    /**
     * Prints timeslots details
     */
    public void print(){
        System.out.println("Day: "+day);
        System.out.println("Begin: "+begin);
        System.out.println("End: "+(begin+1));
        System.out.println("Booked in: "+ bookedin.getName());
        if(isBooked()){
            System.out.println("Booked by: "+bookedby.getName());
        }
    }
}
