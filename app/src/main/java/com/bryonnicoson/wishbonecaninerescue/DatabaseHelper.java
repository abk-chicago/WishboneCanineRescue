package com.bryonnicoson.wishbonecaninerescue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bryon on 7/10/16.
 *
 * SOURCES (Thanks! :)
 * Alex Lockwood:
 * www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html
 *
 * Adam McNeilly:
 * androidessence.com/sqliteopenhelper-and-the-singleton-pattern/
 *
 * INITIALIZE HELPER OBJECT: DatabaseHelper.getInstance(context);
 * (iso "new DatabaseHelper(context)")
 *
 * TODO: Implement ContentProvider to wrap SQLiteDatabase
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "wbcr.db";
    private static final int DATABASE_VERSION = 13;

    // Dog Table
    private static final String DOG_TABLE = "dog";
    private static final String DOG_ID = "_id";
    private static final String DOG_NAME = "name";
    private static final String DOG_BREED = "breed";
    private static final String DOG_SEX = "sex";
    private static final String DOG_AGE = "age";
    private static final String DOG_SIZE = "size";
    private static final String DOG_DESC = "desc";
    private static final String DOG_MIX = "mix";
    private static final String DOG_HASSHOTS = "hasShots";
    private static final String DOG_ALTERED = "altered";
    private static final String DOG_HOUSETRAINED = "housetrained";
    private static final String DOG_SPECIALNEEDS = "specialNeeds";
    private static final String DOG_NOCATS = "noCats";
    private static final String DOG_NODOGS = "noDogs";

    private static final String[] DOG_KEYS = new String[]{DOG_ID, DOG_NAME, DOG_BREED, DOG_SEX, DOG_AGE, DOG_SIZE,
            DOG_DESC, DOG_MIX, DOG_HASSHOTS, DOG_ALTERED, DOG_HOUSETRAINED, DOG_SPECIALNEEDS, DOG_NOCATS, DOG_NODOGS};

    private static final String CREATE_DOG_TABLE = "CREATE TABLE " + DOG_TABLE + " (" + DOG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DOG_NAME + " TEXT," +
            DOG_BREED + " TEXT," + DOG_SEX + " TEXT," + DOG_SIZE + " TEXT," + DOG_AGE + " TEXT," + DOG_DESC + " TEXT," + DOG_MIX + " INTEGER," +
            DOG_HASSHOTS + " INTEGER," + DOG_ALTERED + " INTEGER," + DOG_HOUSETRAINED + " INTEGER," + DOG_SPECIALNEEDS + " INTEGER," +
            DOG_NOCATS + " INTEGER," + DOG_NODOGS + " INTEGER" + ");";

    private static final String DROP_DOG_TABLE = "DROP TABLE IF EXISTS " + DOG_TABLE + ";";


    // Singleton access method
    public static synchronized DatabaseHelper getInstance(Context context) {

        // use application context to prevent leaking of activity context: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // constructor is private to prevent direct instantiation
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading application's database from version " + oldVersion + " to " + newVersion +
                " to " + newVersion + ", which will destroy all existing data!");
        db.execSQL(DROP_DOG_TABLE);
        onCreate(db);
    }

    // TODO: I wonder if what follows should be in another class (like the model?)

    public long insertDog(String name, String breed, String sex, String size, String age, String desc,
                          int mix, int hasShots, int altered, int housetrained, int specialNeeds, int noDogs, int noCats) {

        ContentValues dogV = new ContentValues();
        // dogV.put(DOG_ID, id);                       // autoincrement
        dogV.put(DOG_NAME, name);
        dogV.put(DOG_BREED, breed);
        dogV.put(DOG_SEX, sex);
        dogV.put(DOG_SIZE, size);
        dogV.put(DOG_AGE, age);
        dogV.put(DOG_DESC, desc);
        dogV.put(DOG_MIX, mix);
        dogV.put(DOG_HASSHOTS, hasShots);
        dogV.put(DOG_ALTERED, altered);
        dogV.put(DOG_HOUSETRAINED, housetrained);
        dogV.put(DOG_SPECIALNEEDS, specialNeeds);
        dogV.put(DOG_NODOGS, noDogs);
        dogV.put(DOG_NOCATS, noCats);

        SQLiteDatabase db = this.getWritableDatabase();

        long returnId = db.insert(DOG_TABLE, null, dogV);
        db.close();
        return returnId;
    }

    public Cursor showDogs() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DOG_TABLE,     // table
                DOG_KEYS,                       // columns
                null,                           // selections
                null,                           // selection args
                null,                           // group by
                null,                           // having
                null,                           // order by
                null);                          // limit
        return cursor;
    }

    public Cursor filterList(String query, String[] args) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, args);
        return cursor;
    }
}