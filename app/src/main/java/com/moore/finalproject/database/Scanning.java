package com.moore.finalproject.database;

/**
 * Created by Geoffrey Moore on 3/15/2017.
 */

public class Scanning {

    // define variables for the columns

    private int _id;
    private String covers;
    private String redwellCovers;
    private String redwellTabs;
    private String dividerTabs;
    private String postIts;
    private String coloredSheets;
    private String binderSpines;
    private String envelopes;
    private String standardLng;
    private String carbonCopies;
    private String oversize;

    // constructors

    public Scanning(){

    }

    public Scanning(String covers, String redwellCovers, String redwellTabs, String dividerTabs, String postIts, String coloredSheets, String binderSpines, String envelopes, String standardLng, String carbonCopies, String oversize) {
        this.covers = covers;
        this.redwellCovers = redwellCovers;
        this.redwellTabs = redwellTabs;
        this.dividerTabs = dividerTabs;
        this.postIts = postIts;
        this.coloredSheets = coloredSheets;
        this.binderSpines = binderSpines;
        this.envelopes = envelopes;
        this.standardLng = standardLng;
        this.carbonCopies = carbonCopies;
        this.oversize = oversize;
    }

    // setters and getters


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCovers() {
        return covers;
    }

    public void setCovers(String covers) {
        this.covers = covers;
    }

    public String getRedwellCovers() {
        return redwellCovers;
    }

    public void setRedwellCovers(String redwellCovers) {
        this.redwellCovers = redwellCovers;
    }

    public String getRedwellTabs() {
        return redwellTabs;
    }

    public void setRedwellTabs(String redwellTabs) {
        this.redwellTabs = redwellTabs;
    }

    public String getDividerTabs() {
        return dividerTabs;
    }

    public void setDividerTabs(String dividerTabs) {
        this.dividerTabs = dividerTabs;
    }

    public String getPostIts() {
        return postIts;
    }

    public void setPostIts(String postIts) {
        this.postIts = postIts;
    }

    public String getColoredSheets() {
        return coloredSheets;
    }

    public void setColoredSheets(String coloredSheets) {
        this.coloredSheets = coloredSheets;
    }

    public String getBinderSpines() {
        return binderSpines;
    }

    public void setBinderSpines(String binderSpines) {
        this.binderSpines = binderSpines;
    }

    public String getEnvelopes() {
        return envelopes;
    }

    public void setEnvelopes(String envelopes) {
        this.envelopes = envelopes;
    }

    public String getStandardLng() {
        return standardLng;
    }

    public void setStandardLng(String standardLng) {
        this.standardLng = standardLng;
    }

    public String getCarbonCopies() {
        return carbonCopies;
    }

    public void setCarbonCopies(String carbonCopies) {
        this.carbonCopies = carbonCopies;
    }

    public String getOversize() {
        return oversize;
    }

    public void setOversize(String oversize) {
        this.oversize = oversize;
    }
}
