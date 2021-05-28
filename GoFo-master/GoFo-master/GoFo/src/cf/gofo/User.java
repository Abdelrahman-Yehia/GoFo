package cf.gofo;

import java.util.Random;
import java.util.Scanner;

/**
 * Holds all common data between all users of the program
 * @author 20180142 - 20180251 - 20180294
 */
public class User {
    /**
     * Holds the username
     */
    protected String name;
    /**
     * Holds the user National ID
     */
    protected String ID;
    /**
     * Holds the user Password
     */
    protected String password;
    /**
     * Holds the user phone number
     */
    protected String phone;
    /**
     * Holds the user email address
     */
    protected String email;
    /**
     * Indicates whether the user is a player, a playground owner or an admin
     */
    protected String role;
    /**
     * Holds the user location
     */
    protected Location defLocation;
    /**
     * Holds user active status
     */
    protected boolean active = true;

    /**
     * Creates the user profile
     */
    public User()
    {

        Scanner in= new Scanner(System.in);
        System.out.println("Enter your Name: ");
        name=in.nextLine();
        System.out.println("Enter your ID: ");
        ID=in.nextLine();
        System.out.println("Enter your Password: ");
        password=in.nextLine();
        System.out.println("Enter your Phone: ");
        phone=in.nextLine();
        boolean validated=false;
        while(!validated){
            System.out.println("Enter your Email: ");
            email=in.nextLine();
            if(validEmail(email)){
                validated=true;
            }else{
                System.out.println("Please enter a valid email address!");
            }
        }
        defLocation=new Location(this);
        System.out.println("We have sent a verification code to your email.");
        Random r=new Random();
        int randomInt= r.nextInt(89999)+10000;
        validated=false;
        while(!validated){
            System.out.println("Please enter your verification code: (Psst, its "+randomInt+" )");
            int userV = in.nextInt();
            if(userV==randomInt){
                System.out.println("Validated Successfully!");
                validated=true;
            }else{
                System.out.println("Wrong Varification code!");
            }

        }
        System.out.println("Profile created successfully!");
        //in.close();
    }

    /**
     * Creates a super admin with username and pssword "admin"
     * @param superAdmin
     */
    public User(String superAdmin){
        role = "admin";
        name = "admin";
        password = "admin";
    }

    /**
     * checks whether an email was written correct or not
     * @param email the email to validate
     * @return true or false
     */
    public boolean validEmail(String email){
        int i;
        int atSymbol=0, dotsInDomain=0;
        // Validating name part
        for(i=0;i<email.length();i++){
            if(email.charAt(i)==' '){ // If any space was found return False
                return false;
            }else if(email.charAt(i)=='.'){ // A dot was found
                if(i==0 || i+1==email.length()){ // If a dot was found at the begin or end return False
                    return false;
                }else if(i+1<email.length()){ // If two dots preceding each other was found return False
                    if(email.charAt(i+1)=='.'){
                        return false;
                    }
                }
            }else if(email.charAt(i)=='@'){ // Lets validate domain part
                atSymbol++;
                break;
            }
        }
        int beginOfDomain =++i;
        // Validating domain part part
        for(;i<email.length();i++){
            if(email.charAt(i)==' '){ // Any space was found return False
                return false;
            }else if(email.charAt(i)=='@'){ // Any @ Symbol was found return False
                return false;
            }else if(email.charAt(i)=='.'){ // A dot was found
                if(i+1<email.length()){ // If two dots preceding each other was found return False
                    if(email.charAt(i+1)=='.'){
                        return false;
                    }
                }else if(i==beginOfDomain || i+1==email.length()){ // If a dot was found at the begin or end return False
                    return false;
                }
                dotsInDomain++;
            }else if(email.charAt(i)=='-' &&(i==beginOfDomain || i+1==email.length())){ // If a hyphen was found at the begin or end return False
                return false;
            }
        }
        if(dotsInDomain>0 && atSymbol>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return user national ID
     */
    public String getID() {
        return ID;
    }

    /**
     *
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return user phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return user email address
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return user role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @return user location
     */
    public Location getDefLocation() {
        return defLocation;
    }

    /**
     * Checks user active status
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Changes the user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the user ID
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Changes the user password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Changes the user phone number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Changes the user email address
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Changes the user role
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Changes the user location
     * @param defLocation
     */
    public void setDefLocation(Location defLocation) {
        defLocation = defLocation;
    }

    /**
     * Changes the user active status
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
