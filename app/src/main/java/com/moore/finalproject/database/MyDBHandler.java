package com.moore.finalproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Geoffrey Moore on 3/15/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    // define database variables
    private static final int DATABASE_VERSION = 1;
    private static long row;
    private static final String DATABASE = "jobs.db";
    public static final String TABLE_CLIENTS = "clients";
    public static final String TABLE_NAMING = "naming";
    public static final String TABLE_GROUPING = "grouping";
    public static final String TABLE_SCANNING = "scanning";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CLIENTNAME = "clientname";
    public static final String COLUMN_CONTACTNAME = "contactname";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_CLIENTMATTER = "clientmatter";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PREFIX = "prefix";
    public static final String COLUMN_BOX = "box";
    public static final String COLUMN_INCREMENTING = "incrementing";
    public static final String COLUMN_NAMING = "naming";
    public static final String COLUMN_FILENAMING = "filenaming";
    public static final String COLUMN_DIFFERENTCONTROLNUM = "differentcontrolnum";
    public static final String COLUMN_VOLUME = "volume";
    public static final String COLUMN_DOCUMENTLVL = "documentlvl";
    public static final String COLUMN_GROUPINGREDWELL = "groupingredwell";
    public static final String COLUMN_GROUPINGBINDER = "groupingbinder";
    public static final String COLUMN_GROUPINGFOLDER = "groupingfolder";
    public static final String COLUMN_GROUPINGUP = "groupingup";
    public static final String COLUMN_GROUPINGOUTERMOST = "groupingoutermost";
    public static final String COLUMN_SCOVERS = "scovers";
    public static final String COLUMN_SREDWELLCOVERS = "sredwellcovers";
    public static final String COLUMN_SREDWELLTABS = "sredwelltabs";
    public static final String COLUMN_SDIVIDERTABS = "sdividertabs";
    public static final String COLUMN_SPOSTITS = "spostits";
    public static final String COLUMN_SCOLOREDSHEETS = "scoloredsheets";
    public static final String COLUMN_SBINDERSPINES = "sbinderspines";
    public static final String COLUMN_SENVELOPES = "senvelopes";
    public static final String COLUMN_SSTANDARDLNG = "sstandardlng";
    public static final String COLUMN_SCARBONCOPIES = "scarboncopies";
    public static final String COLUMN_SOVERSIZE = "soversize";


    // define sqlite database variable
    private SQLiteDatabase database;


    // Constructor
    public MyDBHandler(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    // responsible for creating a table for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryClient = "CREATE TABLE " + TABLE_CLIENTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CLIENTNAME + " TEXT NOT NULL, " + COLUMN_CONTACTNAME + " TEXT NOT NULL, " + COLUMN_ADDRESS + " TEXT NOT NULL, " + COLUMN_CLIENTMATTER + " TEXT NOT NULL, " + COLUMN_EMAIL + " TEXT NOT NULL, " + COLUMN_PHONE + " TEXT NOT NULL);";
        String queryNaming = "CREATE TABLE " + TABLE_NAMING + "(" + COLUMN_ID +" INTEGER PRIMARY KEY, " + COLUMN_PREFIX + " , " + COLUMN_BOX + " , " + COLUMN_INCREMENTING + " TEXT NOT NULL, " + COLUMN_NAMING + " TEXT NOT NULL, " + COLUMN_FILENAMING  + " TEXT NOT NULL, " + COLUMN_DIFFERENTCONTROLNUM + " , " + COLUMN_VOLUME + " TEXT NOT NULL);";
        String queryGrouping = "CREATE TABLE " + TABLE_GROUPING + "(" + COLUMN_ID +" INTEGER PRIMARY KEY, " + COLUMN_DOCUMENTLVL + " TEXT NOT NULL, " + COLUMN_GROUPINGREDWELL + " TEXT NOT NULL, " + COLUMN_GROUPINGBINDER + " TEXT NOT NULL, " + COLUMN_GROUPINGFOLDER + " TEXT NOT NULL, " + COLUMN_GROUPINGUP + " TEXT NOT NULL, " + COLUMN_GROUPINGOUTERMOST + " TEXT NOT NULL);";
        String queryScanning = "CREATE TABLE " + TABLE_SCANNING + "(" + COLUMN_ID +" INTEGER PRIMARY KEY, " + COLUMN_SCOVERS + " TEXT NOT NULL, " + COLUMN_SREDWELLCOVERS + " TEXT NOT NULL, "  + COLUMN_SREDWELLTABS + " TEXT NOT NULL, " + COLUMN_SDIVIDERTABS + " TEXT NOT NULL, " + COLUMN_SPOSTITS + " TEXT NOT NULL, " + COLUMN_SCOLOREDSHEETS + " TEXT NOT NULL, " + COLUMN_SBINDERSPINES + " TEXT NOT NULL, "  + COLUMN_SENVELOPES + " TEXT NOT NULL, " + COLUMN_SSTANDARDLNG + " TEXT NOT NULL, " + COLUMN_SCARBONCOPIES + " TEXT NOT NULL, " + COLUMN_SOVERSIZE + " TEXT NOT NULL);";

        db.execSQL(queryClient);
        db.execSQL(queryNaming);
        db.execSQL(queryGrouping);
        db.execSQL(queryScanning);

    }

    // responsible for making updates to an exisiting table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete the entire table if it exisits
        db.execSQL("DROP TABLE IF EXISITS " + TABLE_CLIENTS);
        db.execSQL("DROP TABLE IF EXISITS " + TABLE_NAMING);
        db.execSQL("DROP TABLE IF EXISITS " + TABLE_GROUPING);
        db.execSQL("DROP TABLE IF EXISITS " + TABLE_SCANNING);

        // recreate the table with the new properties
        onCreate(db);
    }

    public MyDBHandler open() throws SQLException {
        database = getWritableDatabase(); // get reference to the database
        return this;
    }


    //add new row to the database
    public void addClient(Client client){
        // contact values is built into android that allows you to add several values in one statement
        ContentValues values = new ContentValues();
        values.put(COLUMN_CLIENTNAME,client.getClientName());
        values.put(COLUMN_CONTACTNAME,client.getContactName());
        values.put(COLUMN_ADDRESS,client.getAddress());
        values.put(COLUMN_CLIENTMATTER,client.getClientMatter());
        values.put(COLUMN_EMAIL,client.getEmail());
        values.put(COLUMN_PHONE,client.getPhone());

        database = getWritableDatabase();
        row = database.insert(TABLE_CLIENTS, null, values);

        // once you're done with database then close it out to give memory back
        database.close();
    }

    public void addNaming(Naming naming){
        // contact values is built into android that allows you to add several values in one statement
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, row);
        values.put(COLUMN_PREFIX,naming.getPrefix());
        values.put(COLUMN_BOX,naming.getBox());
        values.put(COLUMN_INCREMENTING,naming.getIncrementing());
        values.put(COLUMN_NAMING,naming.getNaming());
        values.put(COLUMN_FILENAMING,naming.getFileName());
        values.put(COLUMN_DIFFERENTCONTROLNUM,naming.getDifferentFileName());
        values.put(COLUMN_VOLUME,naming.getVolume());
        database = getWritableDatabase();
        database.insert(TABLE_NAMING, null, values);

        // once you're done with database then close it out to give memory back
        database = getWritableDatabase();
        database.close();
    }

    public void addGrouping(Grouping grouping){
        // contact values is built into android that allows you to add several values in one statement
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, row);
        values.put(COLUMN_DOCUMENTLVL,grouping.getDocumentLvl());
        values.put(COLUMN_GROUPINGREDWELL,grouping.getRedwell());
        values.put(COLUMN_GROUPINGBINDER,grouping.getBinder());
        values.put(COLUMN_GROUPINGFOLDER,grouping.getFolder());
        values.put(COLUMN_GROUPINGUP,grouping.getUp());
        values.put(COLUMN_GROUPINGOUTERMOST,grouping.getOutermost());
        database = getWritableDatabase();
        database.insert(TABLE_GROUPING, null, values);

        // once you're done with database then close it out to give memory back
        database = getWritableDatabase();
        database.close();
    }

    public void addScanning(Scanning scanning){
        // contact values is built into android that allows you to add several values in one statement
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, row);
        values.put(COLUMN_SCOVERS,scanning.getCovers());
        values.put(COLUMN_SREDWELLCOVERS,scanning.getRedwellCovers());
        values.put(COLUMN_SREDWELLTABS,scanning.getRedwellTabs());
        values.put(COLUMN_SDIVIDERTABS,scanning.getDividerTabs());
        values.put(COLUMN_SPOSTITS,scanning.getPostIts());
        values.put(COLUMN_SCOLOREDSHEETS,scanning.getColoredSheets());
        values.put(COLUMN_SBINDERSPINES,scanning.getBinderSpines());
        values.put(COLUMN_SENVELOPES,scanning.getEnvelopes());
        values.put(COLUMN_SSTANDARDLNG,scanning.getStandardLng());
        values.put(COLUMN_SCARBONCOPIES,scanning.getCarbonCopies());
        values.put(COLUMN_SOVERSIZE,scanning.getOversize());
        database = getWritableDatabase();
        database.insert(TABLE_SCANNING, null, values);

        // once you're done with database then close it out to give memory back
        database = getWritableDatabase();
        database.close();
    }


    // Read entries
    public Cursor readEntry(){
        String[] columns = new String[]{COLUMN_ID, COLUMN_CLIENTNAME, COLUMN_CONTACTNAME};

        Cursor c = database.query(TABLE_CLIENTS, columns, null, null, null, null, null);

        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getClient(String id){
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_CLIENTS + " WHERE _id = '" + id + "'", null);

        c.moveToFirst();

        return c;
    }

    public Cursor getNaming(String id) {

        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAMING + " WHERE _id = '" + id + "'", null);

        c.moveToFirst();

        return c;
    }

    public Cursor getGrouping(String id) {
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_GROUPING + " WHERE _id = '" + id + "'", null);

        c.moveToFirst();

        return c;
    }

    public Cursor getScanning(String id) {
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_SCANNING + " WHERE _id = '" + id + "'", null);

        c.moveToFirst();

        return c;
    }
}
