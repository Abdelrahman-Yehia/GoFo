package cf.gofo;

/**
 * Admin class inherits from User class
 * @author 20180142
 */
public class Admin extends User {
    /**
     * Creates a Super Admin
     * @param superAdmin
     */
    public Admin(String superAdmin) {
        super(superAdmin);
    }

    /**
     * Creates a normal admin
     */
    public Admin() {
        super();
    }

    /**
     * Approve a playground for listing
     * @param toApprove the playground that needs approval
     */
    public void approvePlayground(Playground toApprove){
        if(toApprove.isApproved()){
            System.out.println("Playground has been already approved!");
        }
        else{
            toApprove.setApproved(true);
            System.out.println("Playground approved successfully!");
        }
    }

    /**
     * Activate a playground to be listed
     * @param toActivate the playground that needs to be activated
     */
    public void activatePlayground(Playground toActivate){
        if(toActivate.isActive()){
            System.out.println("Playground has been already activated!");
        }
        else{
            toActivate.setActive(true);
            System.out.println("Playground activated successfully!");
        }
    }

    /**
     * Suspends a playground
     * @param toSuspend the playground that will be suspended
     */
    public void suspendPlayground(Playground toSuspend){
        if(!toSuspend.isActive()){
            System.out.println("Playground has been already susspended!");
        }
        else{
            toSuspend.setActive(false);
            System.out.println("Playground suspended successfully!");
        }
    }
}
