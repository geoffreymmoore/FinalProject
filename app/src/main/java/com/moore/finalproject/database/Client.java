package com.moore.finalproject.database;

/**
 * Created by Geoffrey Moore on 3/15/2017.
 */

public class Client {

    // define variables for the columns

    private int _id;
    private String clientName;
    private String contactName;
    private String address;
    private String clientMatter;
    private String email;
    private String phone;

    // constructors

    public Client(){

    }

    public Client(String clientName, String contactName, String address, String clientMatter, String email, String phone) {
        this.clientName = clientName;
        this.contactName = contactName;
        this.address = address;
        this.clientMatter = clientMatter;
        this.email = email;
        this.phone = phone;
    }

    // setters and getters

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientMatter() {
        return clientMatter;
    }

    public void setClientMatter(String clientMatter) {
        this.clientMatter = clientMatter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
