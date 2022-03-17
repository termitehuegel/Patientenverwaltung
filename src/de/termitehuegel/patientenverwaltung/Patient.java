package de.termitehuegel.patientenverwaltung;

public class Patient {
    private String name;
    private String firstName;
    private String bloodGroup;
    private String birthday;
    private String street;
    private String plz;

    public Patient(String name, String firstName, String bloodGroup, String birthday, String street, String plz) {
        this.name = name;
        this.firstName = firstName;
        this.bloodGroup = bloodGroup;
        this.birthday = birthday;
        this.street = street;
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
