package cf.gofo;

/**
 * Complaints class which could be issued by a player
 * @author 20180251
 */
public class Complaint {
    /**
     * A global id for all complaints
     */
    private int globalID=0;
    /**
     * Complaint ID generated from the global id
     */
    private int compID;
    /**
     * Complaint Subject
     */
    private String subject;
    /**
     * Complaint Description
     */
    private String des;
    /**
     * The playgound the Complaint was issued against
     */
    private Playground inPlayground;

    /**
     * The player who issued the complaint
     */
    private Player byPlayer;

    /**
     * Creates a new complaint
     * @param subject
     * @param des
     * @param inPlayground
     * @param byPlayer
     */
    public Complaint(String subject, String des, Playground inPlayground, Player byPlayer) {
        this.subject = subject;
        this.des = des;
        this.inPlayground = inPlayground;
        this.byPlayer = byPlayer;
        compID =globalID++;
    }

    /**
     *
     * @return Global complaints ID
     */
    public int getGlobalID() {
        return globalID;
    }

    /**
     *
     * @return Complaint ID
     */
    public int getCompID() {
        return compID;
    }

    /**
     *
     * @return Complaint Subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @return Complaint Description
     */
    public String getDes() {
        return des;
    }

    /**
     *
     * @return The playground the Complaint was issued against
     */
    public Playground getInPlayground() { return inPlayground; }

    /**
     *
     * @return The player who issued the complaint
     */
    public Player getByPlayer() { return byPlayer; }

    /**
     * Change complaint ID
     * @param compID
     */
    public void setCompID(int compID) {
        this.compID = compID;
    }

    /**
     * Change complaint subject
     * @param name
     */
    public void setSubject(String name) {
        this.subject = name;
    }

    /**
     * Change complaint description
     * @param des
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * Change the playground the Complaint was issued against
     * @param inPlayground
     */
    public void setInPlayground(Playground inPlayground) { this.inPlayground = inPlayground; }

    /**
     * Change the player who issued the complaint
     * @param byPlayer
     */
    public void setByPlayer(Player byPlayer) { this.byPlayer = byPlayer; }
}
