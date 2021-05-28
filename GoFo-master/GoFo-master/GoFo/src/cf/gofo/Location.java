package cf.gofo;

import java.util.Scanner;

/**
 * Location class to hold location of both users and playgrounds, used for filtering playgrounds according to user location
 * @author 20180294
 */
public class Location {
    /**
     * Country
     */
    private String country;
    /**
     * Governorate
     */
    private String governorate;
    /**
     * City
     */
    private String city;
    /**
     * Neighborhood
     */
    private String neighborhood;
    /**
     * Street address
     */
    private String streetaddress;
    /**
     * User who has this location
     */
    private User user;
    /**
     * Playground which has this location
     */
    private Playground playground;

    /**
     * Holds the location for a user
     * @param user
     */
    public Location(User user)
    {
        this.user = user;
        Scanner in = new Scanner(System.in);
        System.out.println("enter your country: ");
        country = in.nextLine();
        System.out.println("enter your governorate: ");
        governorate = in.nextLine();
        System.out.println("enter your city: ");
        city = in.nextLine();
        System.out.println("enter your neighborhood: ");
        neighborhood = in.nextLine();
        System.out.println("enter your streetaddress: ");
        streetaddress = in.nextLine();
        //in.close();
    }

    /**
     * Holds the location for a playground
     * @param playground
     */
    public Location(Playground playground)
    {
        this.playground = playground;
        Scanner in = new Scanner(System.in);
        System.out.println("enter your country: ");
        country = in.nextLine();
        System.out.println("enter your governorate: ");
        governorate = in.nextLine();
        System.out.println("enter your city: ");
        city = in.nextLine();
        System.out.println("enter your neighborhood: ");
        neighborhood = in.nextLine();
        System.out.println("enter your streetaddress: ");
        streetaddress = in.nextLine();
        //in.close();
    }

    /**
     * Changes Country
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Changes governorate
     * @param governorate
     */
    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    /**
     * Changes City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Changes Neighborhood
     * @param neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Changes Street address
     * @param streetaddress
     */
    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    /**
     * Changes user who has this location
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Changes playground located in this location
     * @param playground
     */
    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    /**
     * get country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return governorate
     */
    public String getGovernorate() {
        return governorate;
    }

    /**
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return Neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     *
     * @return Street address
     */
    public String getStreetaddress() {
        return streetaddress;
    }

    /**
     *
     * @return user who has this location
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return playground located in this location
     */
    public Playground getPlayground() {
        return playground;
    }
}
