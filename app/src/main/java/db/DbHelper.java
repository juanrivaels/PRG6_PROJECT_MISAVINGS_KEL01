package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.Goal;
import model.User;
import model.Finance;
import model.FinancialStorage;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "finance_db";
    private static final int DATABASE_VERSION = 1;

    // Table
    public static final String TABLE_USER = "User";
    public static final String TABLE_GOAL = "Goal";
    public static final String TABLE_FINANCE = "Finance";
    public static final String TABLE_FINANCIAL_STORAGE = "FinancialStorage";

    // User Table
    public static final String USER_ID = "User_Id";
    public static final String USER_NAME = "User_Name";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";

    // Goal Table
    public static final String GOAL_ID = "Goal_Id";
    public static final String GOAL_NAME = "Goal_Name";
    public static final String DATE_CREATED = "Date_Created";
    public static final String TARGET_DATE = "Target_Date";
    public static final String TARGET_AMOUNT = "Target_Amount";
    public static final String SAVED_ALREADY = "Saved_Already";
    public static final String MODI_DATE = "Modi_Date";
    public static final String GOAL_COLOR = "Goal_Color";
    public static final String GOAL_ICON = "Goal_Icon";
    public static final String STATUS = "Status";

    // Finance Table
    public static final String FINANCIAL_ID = "Financial_Id";
    public static final String TYPE_OF_FINANCE = "Type_of_Finance";
    public static final String FINANCE_DATE_CREATED = "Date_Created";
    public static final String AMOUNT = "Amount";
    public static final String STORAGE_ID = "Storage_Id";
    public static final String DESCRIPTION = "Description";

    // Financial Storage Table
    public static final String STORAGE_ID_FS = "Storage_Id";
    public static final String STORAGE_NAME = "Storage_Name";
    public static final String STATUS_FS = "Status";


    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ("
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_NAME + " TEXT, "
            + USERNAME + " TEXT, "
            + PASSWORD + " TEXT);";

    private static final String CREATE_TABLE_GOAL = "CREATE TABLE " + TABLE_GOAL + " ("
            + GOAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_ID + " INTEGER, "
            + GOAL_NAME + " TEXT, "
            + DATE_CREATED + " DATE, "
            + TARGET_DATE + " DATE, "
            + TARGET_AMOUNT + " REAL, "
            + SAVED_ALREADY + " REAL, "
            + MODI_DATE + " DATE, "
            + GOAL_COLOR + " TEXT, "
            + GOAL_ICON + " BLOB, "
            + STATUS + " INTEGER, "
            + "FOREIGN KEY(" + USER_ID + ") REFERENCES " + TABLE_USER + "(" + USER_ID + "));";

    private static final String CREATE_TABLE_FINANCE = "CREATE TABLE " + TABLE_FINANCE + " ("
            + FINANCIAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_ID + " INTEGER, "
            + TYPE_OF_FINANCE + " INTEGER, "
            + FINANCE_DATE_CREATED + " DATE, "
            + AMOUNT + " REAL, "
            + STORAGE_ID + " INTEGER, "
            + DESCRIPTION + " TEXT, "
            + "FOREIGN KEY(" + USER_ID + ") REFERENCES " + TABLE_USER + "(" + USER_ID + "), "
            + "FOREIGN KEY(" + STORAGE_ID + ") REFERENCES " + TABLE_FINANCIAL_STORAGE + "(" + STORAGE_ID_FS + "));";

    private static final String CREATE_TABLE_FINANCIAL_STORAGE = "CREATE TABLE " + TABLE_FINANCIAL_STORAGE + " ("
            + STORAGE_ID_FS + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + STORAGE_NAME + " TEXT, "
            + STATUS_FS + " INTEGER);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_GOAL);
        db.execSQL(CREATE_TABLE_FINANCE);
        db.execSQL(CREATE_TABLE_FINANCIAL_STORAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FINANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FINANCIAL_STORAGE);
        onCreate(db);
    }


    public boolean insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getUserName());
        values.put(USERNAME, user.getUsername());
        values.put(PASSWORD, user.getPassword());
        long result = db.insert(TABLE_USER, null, values);
        db.close();
        return result != -1;
    }

    public boolean insertGoal(Goal goal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_ID, goal.getUserId());
        values.put(GOAL_NAME, goal.getGoalName());
        values.put(DATE_CREATED, goal.getDateCreated());
        values.put(TARGET_DATE, goal.getTargetDate());
        values.put(TARGET_AMOUNT, goal.getTargetAmount());
        values.put(SAVED_ALREADY, goal.getSavedAlready());
        values.put(MODI_DATE, goal.getModiDate());
        values.put(GOAL_COLOR, goal.getGoalColor());
        values.put(GOAL_ICON, goal.getGoalIcon());
        values.put(STATUS, goal.getStatus());
        long result = db.insert(TABLE_GOAL, null, values);
        db.close();
        return result != -1;
    }

    public boolean insertFinance(Finance finance) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_ID, finance.getUserId());
        values.put(TYPE_OF_FINANCE, finance.getTypeOfFinance());
        values.put(FINANCE_DATE_CREATED, finance.getDateCreated());
        values.put(AMOUNT, finance.getAmount());
        values.put(STORAGE_ID, finance.getStorageId());
        values.put(DESCRIPTION, finance.getDescription());
        long result = db.insert(TABLE_FINANCE, null, values);
        db.close();
        return result != -1;
    }

    public boolean insertFinancialStorage(FinancialStorage financialStorage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STORAGE_NAME, financialStorage.getStorageName());
        values.put(STATUS_FS, financialStorage.getStatus());
        long result = db.insert(TABLE_FINANCIAL_STORAGE, null, values);
        db.close();
        return result != -1;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUserId(cursor.getInt(cursor.getColumnIndexOrThrow(USER_ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndexOrThrow(USER_NAME)));
                user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(USERNAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(PASSWORD)));
                users.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;
    }

}
