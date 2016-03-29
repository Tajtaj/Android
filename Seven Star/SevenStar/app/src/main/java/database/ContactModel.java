package database;

/**
 * Created by Tajdar khan on 2/11/2016.
 */
public class ContactModel {
    private String ID, firstName, cityName;

    public String getID() {
        return ID;
    }

    public ContactModel() {

    }

    public ContactModel(String id, String firstName, String cityName) {
        this.ID = id;
        this.firstName = firstName;
        this.cityName = cityName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

