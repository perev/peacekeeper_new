package hiof.android14.group26.peacekeeper.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HouseholdHasTasksTable {
	public static final String TABLE_HOUSEHOLD_HAS_TASKS = "household_has_tasks";
	public static final String COLUMN_TASK_ID = "task_id";
	public static final String COLUMN_HOUSEHOLD_ID = "household_id";
	
	
	private static final String DATABASE_CREATE_HOUSEHOLD_HAS_TASKS= 
			  "create table " + TABLE_HOUSEHOLD_HAS_TASKS + "(" + 
			  COLUMN_TASK_ID + " integer primary key " +
			  " FOREIGN KEY (" + COLUMN_TASK_ID + ") REFERENCES task (_id)," +
			  COLUMN_HOUSEHOLD_ID + " integer not null " +
			  " FOREIGN KEY (" + COLUMN_HOUSEHOLD_ID + ") REFERENCES user (_id)," + ");";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_HOUSEHOLD_HAS_TASKS);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.v(TaskTable.class.getName(), "Upgrading database from " + oldVersion + " to " + newVersion + ". All data are lost.");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_HOUSEHOLD_HAS_TASKS);
		onCreate(database);
	}
}
