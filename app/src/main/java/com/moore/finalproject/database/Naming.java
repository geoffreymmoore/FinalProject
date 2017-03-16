package com.moore.finalproject.database;

/**
 * Created by Geoffrey Moore on 3/15/2017.
 */

public class Naming {

    // define variables for the columns

    private int _id;
    private String prefix;
    private String box;
    private String incrementing;
    private String naming;
    private String fileName;
    private String differentFileName;
    private String volume;

    // constructors

    public Naming(){

    }

    public Naming(String prefix, String box, String incrementing, String naming, String fileName, String volume) {

        this.prefix = prefix;
        this.box = box;
        this.incrementing = incrementing;
        this.naming = naming;
        this.fileName = fileName;
        this.volume = volume;
    }

    public Naming(String prefix, String box, String incrementing, String naming, String fileName, String differentFileName, String volume) {
        this.prefix = prefix;
        this.box = box;
        this.incrementing = incrementing;
        this.naming = naming;
        this.fileName = fileName;
        this.differentFileName = differentFileName;
        this.volume = volume;
    }

    // setters and getters

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getIncrementing() {
        return incrementing;
    }

    public void setIncrementing(String incrementing) {
        this.incrementing = incrementing;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDifferentFileName() {
        return differentFileName;
    }

    public void setDifferentFileName(String differentFileName) {
        this.differentFileName = differentFileName;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
