package hiof.android14.group26.peacekeeper.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "show.db";
	private static final int DATABASE_VERSION = 2;

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		HouseholdTable.onCreate(database);
		UserTable.onCreate(database);
		TaskTable.onCreate(database);
		HouseholdHasTasksTable.onCreate(database);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		HouseholdTable.onUpgrade(database, oldVersion, newVersion);
		UserTable.onUpgrade(database, oldVersion, newVersion);
		TaskTable.onUpgrade(database, oldVersion, newVersion);
		HouseholdHasTasksTable.onUpgrade(database, oldVersion, newVersion);
	}
}
