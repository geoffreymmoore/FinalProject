package com.moore.finalproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.moore.finalproject.database.Client;
import com.moore.finalproject.database.Grouping;
import com.moore.finalproject.database.MyDBHandler;
import com.moore.finalproject.database.Naming;
import com.moore.finalproject.database.Scanning;

public class CreateActivity extends AppCompatActivity {

    // define widgets

    private EditText clientNameET, contactNameET, addressET, clientMatterET, emailET, phoneET, prefixET, boxET, incrementingET, namingET, differentControlNumET, volumeET;
    private CheckBox redwellCB, binderCB, folderCB, upCB, outermostCB;
    private RadioGroup namingRG, groupingRG, coversRG, redwellCoversRG, redwellTabsRG, dividerTabsRG, postItsRG, coloredSheetsRG, binderSpinesRG, standardLngRG, carbonCopiesRG, oversizeRG;
    private RadioButton fileNameSameRB, fileNameDifferentRB, lowestRB, outerMostRB, lddRB, coversYesRB, coversNoRB, redwellCoversYesRB, redwellCoversNoRB, redwellTabsYesRB, redwellTabsNoRB, dividersYesRB, dividersNoRB, postItsYesRB, postItsNoRB, coloredSheetsYesRB, coloredSheetsNoRB, binderSpinesYesRB, binderSpinesNoRB, envelopesYesRB, envelopesNoRB, standardLngYesRB, standardLngNoRB, carbonCopiesYesRB, carbonCopiesNoRB, oversizeYesRB, oversizeNoRB;
    private Button submitReviewButton;

    //define db handler
    MyDBHandler dbHandler;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 1:
                        clientNameET = (EditText) findViewById(R.id.clientNameET);
                        contactNameET = (EditText) findViewById(R.id.contactNameET);
                        addressET = (EditText) findViewById(R.id.addressET);
                        clientMatterET = (EditText) findViewById(R.id.clientMatterNumET);
                        emailET = (EditText) findViewById(R.id.emailET);
                        phoneET = (EditText) findViewById(R.id.phoneNumberET);
                        break;
                    case 2:
                        prefixET = (EditText) findViewById(R.id.prefixET);
                        boxET = (EditText) findViewById(R.id.boxET);
                        incrementingET = (EditText) findViewById(R.id.incrementingET);
                        namingET = (EditText) findViewById(R.id.namingET);
                        differentControlNumET = (EditText) findViewById(R.id.differentControlNumET);
                        fileNameSameRB = (RadioButton) findViewById(R.id.fileNameSameRB);
                        fileNameDifferentRB = (RadioButton) findViewById(R.id.fileNameDifferentRB);
                        volumeET = (EditText) findViewById(R.id.volumeET);
                        break;
                    case 3:
                        lowestRB = (RadioButton) findViewById(R.id.lowestRB);
                        outerMostRB = (RadioButton) findViewById(R.id.outerMostRB);
                        lddRB = (RadioButton) findViewById(R.id.lddRB);
                        redwellCB = (CheckBox) findViewById(R.id.groupingRedwellCB);
                        binderCB = (CheckBox) findViewById(R.id.groupingBinderCB);
                        folderCB = (CheckBox)  findViewById(R.id.groupingFolderCB);
                        upCB = (CheckBox) findViewById(R.id.groupingUpCB);
                        outermostCB = (CheckBox) findViewById(R.id.groupingOutermostCB);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // instantiate the MyDBHandler constructor
        dbHandler = new MyDBHandler(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submitClick(View view) {

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

        String clientName = clientNameET.getText().toString();
        String contactName = contactNameET.getText().toString();
        String address = addressET.getText().toString();
        String clientMatter = clientMatterET.getText().toString();
        String email = emailET.getText().toString();
        String phone = phoneET.getText().toString();

        // add client to database
        Client client = new Client(clientName, contactName, address, clientMatter, email, phone);
        dbHandler.addClient(client);

        // clear the text fields
        clientNameET.setText("");
        contactNameET.setText("");
        addressET.setText("");
        clientMatterET.setText("");
        emailET.setText("");
        phoneET.setText("");

        String prefix = prefixET.getText().toString();
        String box = boxET.getText().toString();
        String incrementing = incrementingET.getText().toString();
        String naming = namingET.getText().toString();
        String volume = volumeET.getText().toString();

        if(fileNameSameRB.isChecked()){
            String fileNaming = "same";

            Naming namingDB = new Naming(prefix, box, incrementing, naming, fileNaming, volume);
            dbHandler.addNaming(namingDB);

            //clear the text fields and reset Radio Button
            prefixET.setText("");
            boxET.setText("");
            incrementingET.setText("");
            namingET.setText("");
            volumeET.setText("");
            fileNameSameRB.setChecked(true);
            fileNameDifferentRB.setChecked(false);
            differentControlNumET.setVisibility(View.GONE);
        }else {
            String fileNaming = "diff";
            String differentControlNum = differentControlNumET.getText().toString();

            Naming namingDB = new Naming(prefix, box, incrementing, naming, fileNaming, differentControlNum, volume);
            dbHandler.addNaming(namingDB);

            //clear the text fields and reset Radio Button
            prefixET.setText("");
            boxET.setText("");
            incrementingET.setText("");
            namingET.setText("");
            volumeET.setText("");
            fileNameSameRB.setChecked(true);
            fileNameDifferentRB.setChecked(false);
            differentControlNumET.setVisibility(View.GONE);
        }

        String docLvl, redwell, binder, folder, up, outermost;

        if (lowestRB.isChecked()){
            docLvl = "lowest";
        } else if (outerMostRB.isChecked()){
            docLvl = "outer";
        } else {
            docLvl = "ldd";
        }

        if(redwellCB.isChecked()) {
            redwell = "y";
        } else {
            redwell = "n";
        }

        if (binderCB.isChecked()){
            binder = "y";
        } else {
            binder = "n";
        }

        if (folderCB.isChecked())
        {
            folder = "y";
        } else {
            folder = "n";
        }

        if (upCB.isChecked()){
            up = "y";
        }else {
            up = "n";
        }

        if (outermostCB.isChecked()){
            outermost = "y";
        }else {
            outermost = "n";
        }

        Grouping grouping = new Grouping(docLvl, redwell, binder, folder, up, outermost);
        dbHandler.addGrouping(grouping);

        //reset Radio Button and Checkboxes
        lowestRB.setChecked(true);
        outerMostRB.setChecked(false);
        lddRB.setChecked(false);

        redwellCB.setChecked(false);
        binderCB.setChecked(false);
        folderCB.setChecked(false);
        upCB.setChecked(false);
        outermostCB.setChecked(false);

        String covers, redwellCovers, redwellTabs, dividerTabs, postIts, coloredSheets, binderSpines, envelopes, standardLng, carbonCopies, oversize;

        if (coversYesRB.isChecked()){
            covers = "y";
        } else{
            covers = "n";
        }

        if (redwellCoversYesRB.isChecked()){
            redwellCovers = "y";
        } else{
            redwellCovers = "n";
        }

        if (redwellTabsYesRB.isChecked()){
            redwellTabs = "y";
        } else{
            redwellTabs = "n";
        }

        if (dividersYesRB.isChecked()){
            dividerTabs = "y";
        } else{
            dividerTabs = "n";
        }

        if (postItsYesRB.isChecked()){
            postIts = "y";
        } else{
            postIts = "n";
        }

        if (coloredSheetsYesRB.isChecked()){
            coloredSheets = "y";
        } else{
            coloredSheets = "n";
        }

        if (binderSpinesYesRB.isChecked()){
            binderSpines = "y";
        } else{
            binderSpines = "n";
        }

        if (envelopesYesRB.isChecked()){
            envelopes = "y";
        } else{
            envelopes = "n";
        }

        if (standardLngYesRB.isChecked()){
            standardLng = "y";
        } else{
            standardLng = "n";
        }

        if (carbonCopiesYesRB.isChecked()){
            carbonCopies = "y";
        } else{
            carbonCopies = "n";
        }

        if (oversizeYesRB.isChecked()){
            oversize = "y";
        } else{
            oversize = "n";
        }

        Scanning scanning = new Scanning(covers, redwellCovers, redwellTabs, dividerTabs, postIts, coloredSheets, binderSpines, envelopes, standardLng, carbonCopies, oversize);
        dbHandler.addScanning(scanning);

        // reset radio buttons
        coversYesRB.setChecked(true);
        coversNoRB.setChecked(false);
        redwellCoversYesRB.setChecked(true);
        redwellCoversNoRB.setChecked(false);
        dividersYesRB.setChecked(true);
        dividersNoRB.setChecked(false);
        postItsYesRB.setChecked(true);
        postItsNoRB.setChecked(false);
        coloredSheetsYesRB.setChecked(true);
        coloredSheetsNoRB.setChecked(false);
        binderSpinesYesRB.setChecked(true);
        binderSpinesNoRB.setChecked(false);
        envelopesYesRB.setChecked(true);
        envelopesNoRB.setChecked(false);
        standardLngYesRB.setChecked(true);
        standardLngNoRB.setChecked(false);
        oversizeYesRB.setChecked(true);
        oversizeNoRB.setChecked(false);

        Intent intent = new Intent(this, CreateOrDisplayActivity.class);
        startActivity(intent);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_create, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return ClientFragment.newInstance();
                case 1:
                    return NamingFragment.newInstance();
                case 2:
                    return GroupingFragment.newInstance();
                case 3:
                    return ScanningFragment.newInstance();
            }
            return PlaceholderFragment.newInstance(1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Client";
                case 1:
                    return "Naming";
                case 2:
                    return "Grouping";
                case 3:
                    return "Scanning";
            }
            return null;
        }
    }

}
