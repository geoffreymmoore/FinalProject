package com.moore.finalproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moore.finalproject.database.MyDBHandler;

public class DisplayActivity extends AppCompatActivity {

    // define widgets

    private EditText clientNameET, contactNameET, addressET, clientMatterET, emailET, phoneET, prefixET, boxET, incrementingET, namingET, differentControlNumET, volumeET;
    private CheckBox redwellCB, binderCB, folderCB, upCB, outermostCB;
    private RadioGroup namingRG, groupingRG, coversRG, redwellCoversRG, redwellTabsRG, dividerTabsRG, postItsRG, coloredSheetsRG, binderSpinesRG, standardLngRG, carbonCopiesRG, oversizeRG;
    private RadioButton fileNameSameRB, fileNameDifferentRB, lowestRB, outerMostRB, lddRB, coversYesRB, coversNoRB, redwellCoversYesRB, redwellCoversNoRB, redwellTabsYesRB, redwellTabsNoRB, dividersYesRB, dividersNoRB, postItsYesRB, postItsNoRB, coloredSheetsYesRB, coloredSheetsNoRB, binderSpinesYesRB, binderSpinesNoRB, envelopesYesRB, envelopesNoRB, standardLngYesRB, standardLngNoRB, carbonCopiesYesRB, carbonCopiesNoRB, oversizeYesRB, oversizeNoRB;
    private Button submitReviewButton;

    private String same = "same";
    private String yes = "y";
    private String lowest = "lowest";
    private String outer = "outer";



    //define SQL controller variable
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String id = getIntent().getExtras().getString("id");

        // instantiate the handler constructor
        dbHandler = new MyDBHandler(this);



        clientNameET = (EditText) findViewById(R.id.clientNameET);
        contactNameET = (EditText) findViewById(R.id.contactNameET);
        addressET = (EditText) findViewById(R.id.addressET);
        clientMatterET = (EditText) findViewById(R.id.clientMatterNumET);
        emailET = (EditText) findViewById(R.id.emailET);
        phoneET = (EditText) findViewById(R.id.phoneNumberET);
        prefixET = (EditText) findViewById(R.id.prefixET);
        boxET = (EditText) findViewById(R.id.boxET);
        incrementingET = (EditText) findViewById(R.id.incrementingET);
        namingET = (EditText) findViewById(R.id.namingET);
        differentControlNumET = (EditText) findViewById(R.id.differentControlNumET);
        fileNameSameRB = (RadioButton) findViewById(R.id.fileNameSameRB);
        fileNameDifferentRB = (RadioButton) findViewById(R.id.fileNameDifferentRB);
        volumeET = (EditText) findViewById(R.id.volumeET);
        lowestRB = (RadioButton) findViewById(R.id.lowestRB);
        outerMostRB = (RadioButton) findViewById(R.id.outerMostRB);
        lddRB = (RadioButton) findViewById(R.id.lddRB);
        redwellCB = (CheckBox) findViewById(R.id.groupingRedwellCB);
        binderCB = (CheckBox) findViewById(R.id.groupingBinderCB);
        folderCB = (CheckBox)  findViewById(R.id.groupingFolderCB);
        upCB = (CheckBox) findViewById(R.id.groupingUpCB);
        outermostCB = (CheckBox) findViewById(R.id.groupingOutermostCB);
        coversYesRB = (RadioButton) findViewById(R.id.coversYesRB);
        coversNoRB = (RadioButton) findViewById(R.id.coversNoRB);
        redwellCoversYesRB = (RadioButton) findViewById(R.id.redwellCoversYesRB);
        redwellCoversNoRB = (RadioButton) findViewById(R.id.redwellCoversNoRB);
        redwellTabsYesRB = (RadioButton) findViewById(R.id.redwellTabsYesRB);
        redwellTabsNoRB = (RadioButton) findViewById(R.id.redwellTabsNoRB);
        dividersYesRB = (RadioButton) findViewById(R.id.dividersYesRB);
        dividersNoRB = (RadioButton) findViewById(R.id.dividersNoRB);
        postItsYesRB = (RadioButton) findViewById(R.id.postItsYesRB);
        postItsNoRB = (RadioButton) findViewById(R.id.postItsNoRB);
        coloredSheetsYesRB = (RadioButton) findViewById(R.id.coloredSheetsYesRB);
        coloredSheetsNoRB = (RadioButton) findViewById(R.id.coloredSheetsNoRB);
        binderSpinesYesRB = (RadioButton) findViewById(R.id.binderSpinesYesRB);
        binderSpinesNoRB = (RadioButton) findViewById(R.id.binderSpinesNoRB);
        envelopesYesRB = (RadioButton) findViewById(R.id.envelopesYesRB);
        envelopesNoRB = (RadioButton) findViewById(R.id.envelopesNoRB);
        standardLngYesRB = (RadioButton) findViewById(R.id.standardLngYesRB);
        standardLngNoRB = (RadioButton) findViewById(R.id.standardLngNoRB);
        carbonCopiesYesRB = (RadioButton) findViewById(R.id.carbonCopiesYesRB);
        carbonCopiesNoRB = (RadioButton) findViewById(R.id.carbonCopiesNoRB);
        oversizeYesRB = (RadioButton) findViewById(R.id.oversizeYesRB);
        oversizeNoRB = (RadioButton) findViewById(R.id.oversizeNoRB);
        submitReviewButton = (Button) findViewById(R.id.submitReviewButton);

        submitReviewButton.setVisibility(View.GONE);

        dbHandler.open();
        Cursor client = dbHandler.getClient(id);

        clientNameET.setText(client.getString(1));
        clientNameET.setFocusable(false);
        contactNameET.setText(client.getString(2));
        contactNameET.setFocusable(false);
        addressET.setText(client.getString(3));
        addressET.setFocusable(false);
        clientMatterET.setText(client.getString(4));
        clientMatterET.setFocusable(false);
        emailET.setText(client.getString(5));
        emailET.setFocusable(false);
        phoneET.setText(client.getString(6));
        phoneET.setFocusable(false);

        Cursor naming = dbHandler.getNaming(id);

        prefixET.setText(naming.getString(1));
        prefixET.setFocusable(false);
        boxET.setText(naming.getString(2));
        boxET.setFocusable(false);
        incrementingET.setText(naming.getString(3));
        incrementingET.setFocusable(false);
        namingET.setText(naming.getString(4));
        namingET.setFocusable(false);

        String sameOrDiff = naming.getString(5);

        if (sameOrDiff.equals(same)){
            fileNameSameRB.setChecked(true);
            fileNameDifferentRB.setChecked(false);
            differentControlNumET.setVisibility(View.GONE);
            fileNameSameRB.setEnabled(false);
            fileNameDifferentRB.setEnabled(false);
        } else {
            fileNameSameRB.setChecked(false);
            fileNameDifferentRB.setChecked(true);
            differentControlNumET.setVisibility(View.VISIBLE);
            differentControlNumET.setText(naming.getString(6));
            differentControlNumET.setFocusable(false);
            fileNameSameRB.setEnabled(false);
            fileNameDifferentRB.setEnabled(false);
        }
        volumeET.setText(naming.getString(7));
        volumeET.setFocusable(false);

        Cursor grouping = dbHandler.getGrouping(id);

        String docLvl = grouping.getString(1);
        if (docLvl.equals(lowest)){
            lowestRB.setChecked(true);
            outerMostRB.setChecked(false);
            lddRB.setChecked(false);
            lowestRB.setEnabled(false);
            outerMostRB.setEnabled(false);
            lddRB.setEnabled(false);
        } else if (docLvl.equals(outer)){
            lowestRB.setChecked(false);
            outerMostRB.setChecked(true);
            lddRB.setChecked(false);
            lowestRB.setEnabled(false);
            outerMostRB.setEnabled(false);
            lddRB.setEnabled(false);
        } else {
            lowestRB.setChecked(false);
            outerMostRB.setChecked(false);
            lddRB.setChecked(true);
            lowestRB.setEnabled(false);
            outerMostRB.setEnabled(false);
            lddRB.setEnabled(false);
        }

        String redwell = grouping.getString(2);
        if (redwell.equals(yes)){
            redwellCB.setChecked(true);
            redwellCB.setEnabled(false);
        } else {
            redwellCB.setChecked(false);
            redwellCB.setEnabled(false);
        }

        String binder = grouping.getString(3);
        if (binder.equals(yes)){
            binderCB.setChecked(true);
            binderCB.setEnabled(false);
        } else{
            binderCB.setChecked(false);
            binderCB.setEnabled(false);
        }

        String folder = grouping.getString(4);
        if (folder.equals(yes)){
            folderCB.setChecked(true);
            folderCB.setEnabled(false);
        }else {
            folderCB.setChecked(false);
            folderCB.setEnabled(false);
        }

        String up = grouping.getString(5);
        if (up.equals(yes)){
            upCB.setChecked(true);
            upCB.setEnabled(false);
        } else {
            upCB.setChecked(false);
            upCB.setEnabled(false);
        }

        String outerMost = grouping.getString(6);
        if (outerMost.equals(yes)){
            outermostCB.setChecked(true);
            outermostCB.setEnabled(false);
        }else {
            outermostCB.setChecked(false);
            outermostCB.setEnabled(false);
        }

        Cursor scanning = dbHandler.getScanning(id);

        String covers = scanning.getString(1);
        if (covers.equals(yes)){
            coversYesRB.setChecked(true);
            coversNoRB.setChecked(false);
            coversYesRB.setEnabled(false);
            coversNoRB.setEnabled(false);
        }else  {
            coversYesRB.setChecked(false);
            coversNoRB.setChecked(true);
            coversYesRB.setEnabled(false);
            coversNoRB.setEnabled(false);
        }

        String redwellCovers = scanning.getString(2);
        if (redwellCovers.equals(yes)){
            redwellCoversYesRB.setChecked(true);
            redwellCoversNoRB.setChecked(false);
            redwellCoversYesRB.setEnabled(false);
            redwellCoversNoRB.setEnabled(false);
        } else{
            redwellCoversYesRB.setChecked(false);
            redwellCoversNoRB.setChecked(true);
            redwellCoversYesRB.setEnabled(false);
            redwellCoversNoRB.setEnabled(false);
        }

        String redwellTabs = scanning.getString(3);
        if (redwellTabs.equals(yes)){
            redwellTabsYesRB.setChecked(true);
            redwellTabsNoRB.setChecked(false);
            redwellTabsYesRB.setEnabled(false);
            redwellTabsNoRB.setEnabled(false);
        } else{
            redwellTabsYesRB.setChecked(false);
            redwellTabsNoRB.setChecked(true);
            redwellTabsYesRB.setEnabled(false);
            redwellTabsNoRB.setEnabled(false);
        }

        String divider = scanning.getString(4);
        if (divider.equals(yes)){
            dividersYesRB.setChecked(true);
            dividersNoRB.setChecked(false);
            dividersYesRB.setEnabled(false);
            dividersNoRB.setEnabled(false);
        } else {
            dividersYesRB.setChecked(false);
            dividersNoRB.setChecked(true);
            dividersYesRB.setEnabled(false);
            dividersNoRB.setEnabled(false);
        }

        String postIts = scanning.getString(5);
        if (postIts.equals(yes)){
            postItsYesRB.setChecked(true);
            postItsNoRB.setChecked(false);
            postItsYesRB.setEnabled(false);
            postItsNoRB.setEnabled(false);
        } else {
            postItsYesRB.setChecked(false);
            postItsNoRB.setChecked(true);
            postItsYesRB.setEnabled(false);
            postItsNoRB.setEnabled(false);
        }

        String colored = scanning.getString(6);
        if (colored.equals(yes)){
            coloredSheetsYesRB.setChecked(true);
            coloredSheetsNoRB.setChecked(false);
            coloredSheetsYesRB.setEnabled(false);
            coloredSheetsNoRB.setEnabled(false);
        } else {
            coloredSheetsYesRB.setChecked(false);
            coloredSheetsNoRB.setChecked(true);
            coloredSheetsYesRB.setEnabled(false);
            coloredSheetsNoRB.setEnabled(false);
        }

        String binderSpines = scanning.getString(7);
        if (binderSpines.equals(yes)){
            binderSpinesYesRB.setChecked(true);
            binderSpinesNoRB.setChecked(false);
            binderSpinesYesRB.setEnabled(false);
            binderSpinesNoRB.setEnabled(false);
        } else {
            binderSpinesYesRB.setChecked(false);
            binderSpinesNoRB.setChecked(true);
            binderSpinesYesRB.setEnabled(false);
            binderSpinesNoRB.setEnabled(false);
        }

        String envelope = scanning.getString(8);
        if (envelope.equals(yes)){
            envelopesYesRB.setChecked(true);
            envelopesNoRB.setChecked(false);
            envelopesYesRB.setEnabled(false);
            envelopesNoRB.setEnabled(false);
        } else {
            envelopesYesRB.setChecked(false);
            envelopesNoRB.setChecked(true);
            envelopesYesRB.setEnabled(false);
            envelopesNoRB.setEnabled(false);
        }

        String stdLng = scanning.getString(9);
        if (stdLng.equals(yes)){
            standardLngYesRB.setChecked(true);
            standardLngNoRB.setChecked(false);
            standardLngYesRB.setEnabled(false);
            standardLngNoRB.setEnabled(false);
        } else {
            standardLngYesRB.setChecked(false);
            standardLngNoRB.setChecked(true);
            standardLngYesRB.setEnabled(false);
            standardLngNoRB.setEnabled(false);
        }

        String carbon = scanning.getString(10);
        if (carbon.equals(yes)){
            carbonCopiesYesRB.setChecked(true);
            carbonCopiesNoRB.setChecked(false);
            carbonCopiesYesRB.setEnabled(false);
            carbonCopiesNoRB.setEnabled(false);
        } else {
            carbonCopiesYesRB.setChecked(false);
            carbonCopiesNoRB.setChecked(true);
            carbonCopiesYesRB.setEnabled(false);
            carbonCopiesNoRB.setEnabled(false);
        }

        String oversize = scanning.getString(11);
        if (oversize.equals(yes)){
            oversizeYesRB.setChecked(true);
            oversizeNoRB.setChecked(false);
            oversizeYesRB.setEnabled(false);
            oversizeNoRB.setEnabled(false);
        }else {
            oversizeYesRB.setChecked(false);
            oversizeNoRB.setChecked(true);
            oversizeYesRB.setEnabled(false);
            oversizeNoRB.setEnabled(false);
        }

    }

    public void returnClick(View view) {
        Intent intent = new Intent(this, CreateOrDisplayActivity.class);
        startActivity(intent);
    }
}
