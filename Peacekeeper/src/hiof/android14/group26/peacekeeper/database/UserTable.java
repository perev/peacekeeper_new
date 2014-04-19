package hiof.android14.group26.peacekeeper.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserTable {
	public static final String TABLE_USER = "user";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_FIRST_NAME = "first_name";
	public static final String COLUMN_LAST_NAME = "last_name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_HOUSEHOLD_ID = "household_id";
	
	private static final String DATABASE_CREATE_USER = 
			  "create table " + TABLE_USER + "(" + 
			  COLUMN_ID + " integer primary key autoincrement, " + 
			  COLUMN_FIRST_NAME + " text not null, " +
			  COLUMN_LAST_NAME + " text not null, " +
			  COLUMN_EMAIL + " text not null, " +
			  COLUMN_PASSWORD + " integer not null, " +
			  COLUMN_HOUSEHOLD_ID + " integer " + 
			  " FOREIGN KEY (" + COLUMN_HOUSEHOLD_ID + ") REFERENCES household (_id));";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_USER);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.v(UserTable.class.getName(), "Upgrading database from " + oldVersion + " to " + newVersion + ". All data are lost.");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		onCreate(database);
	}
}
