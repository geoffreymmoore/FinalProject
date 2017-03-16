package com.moore.finalproject.database;

/**
 * Created by Geoffrey Moore on 3/15/2017.
 */

public class Grouping {

    // define variables for the columns

    private int _id;
    private String documentLvl;
    private String redwell;
    private String binder;
    private String folder;
    private String up;
    private String outermost;

    // constructors

    public Grouping(){

    }

    public Grouping(String documentLvl, String redwell, String binder, String folder, String up, String outermost) {
        this.documentLvl = documentLvl;
        this.redwell = redwell;
        this.binder = binder;
        this.folder = folder;
        this.up = up;
        this.outermost = outermost;
    }

    // setters and getters

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDocumentLvl() {
        return documentLvl;
    }

    public void setDocumentLvl(String documentLvl) {
        this.documentLvl = documentLvl;
    }

    public String getRedwell() {
        return redwell;
    }

    public void setRedwell(String redwell) {
        this.redwell = redwell;
    }

    public String getBinder() {
        return binder;
    }

    public void setBinder(String binder) {
        this.binder = binder;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getOutermost() {
        return outermost;
    }

    public void setOutermost(String outermost) {
        this.outermost = outermost;
    }
}
