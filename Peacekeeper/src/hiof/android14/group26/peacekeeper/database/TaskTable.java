package hiof.android14.group26.peacekeeper.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TaskTable {
	public static final String TABLE_TASK = "task";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_CREATION_DATE = "creation_date";
	public static final String COLUMN_DUE_DATE = "due_date";
	public static final String COLUMN_CREATOR = "creator_id";
	public static final String COLUMN_RESPONSIBLE = "responsible_id";
	
	private static final String DATABASE_CREATE_TASK = 
			  "create table " + TABLE_TASK + "(" + 
			  COLUMN_ID + " integer primary key autoincrement, " + 
			  COLUMN_DESCRIPTION + " text not null, " +
			  COLUMN_CREATION_DATE + " text not null, " +
			  COLUMN_DUE_DATE + " text not null, " +
			  COLUMN_CREATOR + " integer not null " +
			  " FOREIGN KEY (" + COLUMN_CREATOR + ") REFERENCES user (_id)," +
			  COLUMN_RESPONSIBLE + " integer " + 
			  " FOREIGN KEY (" + COLUMN_RESPONSIBLE + ") REFERENCES user (_id));";


	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_TASK);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.v(TaskTable.class.getName(), "Upgrading database from " + oldVersion + " to " + newVersion + ". All data are lost.");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
		onCreate(database);
	}

}

