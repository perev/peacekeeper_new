package hiof.android14.group26.peacekeeper.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HouseholdTable {
	public static final String TABLE_HOUSEHOLD = "household";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	
	private static final String DATABASE_CREATE_HOUSEHOLD = 
			  "create table " + TABLE_HOUSEHOLD + "(" + 
			  COLUMN_ID + " integer primary key autoincrement, " +
			  COLUMN_NAME + " text not null, " + ");";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_HOUSEHOLD);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.v(HouseholdTable.class.getName(), "Upgrading database from " + oldVersion + " to " + newVersion + ". All data are lost.");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_HOUSEHOLD);
		onCreate(database);
	}
}
