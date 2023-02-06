package Databas;

import Store.Formater;

public class Customer {
    Formater formater = new Formater();
    private Boolean test = false;
    private Boolean loggedIn = false;

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String district;
    protected String zipCode;
    protected String phoneNr;
    protected String eMail;
    protected String customerPassWord;

    // Default constructor
    public Customer(){};

    public Customer(int id, String firstName, String lastName, String address,
                    String district, String zipCode, String phoneNr, String eMail,
                    String customerPassWord) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.district = district;
        this.zipCode = zipCode;
        this.phoneNr = phoneNr;
        this.eMail = eMail;
        this.customerPassWord = customerPassWord;
    }



    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCustomerPassWord() {
        return customerPassWord;
    }

    public void setCustomerPassWord(String customerPassWord) {
        this.customerPassWord = customerPassWord;
    }


    public String customerData() {

        return "Customer: " + getFirstName() + " " +
                getLastName() +
                formater.alignProducts(getFirstName()+getLastName())
                +"Adress: " + getAddress() +
                formater.alignProducts(getAddress());
    }


}


