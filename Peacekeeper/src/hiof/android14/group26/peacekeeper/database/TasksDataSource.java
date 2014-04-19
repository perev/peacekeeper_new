package hiof.android14.group26.peacekeeper.database;

import java.util.List;

import hiof.android14.group26.peacekeeper.models.Tasks;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


//TODO: add remaining code for tasks (add another method for creating task where responsible is not null?)
//TODO: add code for user, household and householdhastasks (might split this in different methods)

public class TasksDataSource {
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	
	private String[] allTasksColumns = { 
					TaskTable.COLUMN_ID,
					TaskTable.COLUMN_DESCRIPTION,
					TaskTable.COLUMN_CREATION_DATE,
					TaskTable.COLUMN_DUE_DATE,
					TaskTable.COLUMN_CREATOR,
					TaskTable.COLUMN_RESPONSIBLE};
	
	private String[] allUserColumns = {
					UserTable.COLUMN_ID,
					UserTable.COLUMN_FIRST_NAME,
					UserTable.COLUMN_LAST_NAME,
					UserTable.COLUMN_EMAIL,
					UserTable.COLUMN_PASSWORD,
					UserTable.COLUMN_HOUSEHOLD_ID};
	
	private String[] allHouseholdColumns = {
					HouseholdTable.COLUMN_ID,
					HouseholdTable.COLUMN_NAME};
					
	private String[] allHouseholdHasTasksColumns = {
					HouseholdHasTasksTable.COLUMN_TASK_ID,
					HouseholdHasTasksTable.COLUMN_HOUSEHOLD_ID};

	public TasksDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}
	
	//Create task without responsible household member
	public Tasks createTask(String description, String creation_date, String due_date, String creator){
		ContentValues values = new ContentValues();
		
		values.put(TaskTable.COLUMN_DESCRIPTION, description);
		values.put(TaskTable.COLUMN_CREATION_DATE, creation_date);
		values.put(TaskTable.COLUMN_DUE_DATE, due_date);
		values.put(TaskTable.COLUMN_CREATOR, creator);
		
		long insertId = database.insert(TaskTable.TABLE_TASK, null, values);
		
		return getTask(insertId);
	}
	
	public Tasks getTask(long id){
	
		Cursor cursor = database.query(TaskTable.TABLE_TASK,
						allTasksColumns,
						TaskTable.COLUMN_ID + " = " + id,
						null, null, null, null);
		
		cursor.moveToFirst();
		Tasks task = cursorToTask(cursor);
		cursor.close();
		
		return task;
	}
	
	//TODO: finish this method: Get all tasks in one household
	public List<Tasks> getAllTasks() {return null;}
	
	//TODO: finish this method: Delete single task
	public void deleteTask(Tasks task){};
	
	//Convert cursor with data to task-object
	private Tasks cursorToTask(Cursor cursor) {
		Tasks task = new Tasks();
		
		task.setId(cursor.getInt(0));
		task.setDescription(cursor.getString(1));
		task.setCreation_date(cursor.getString(2));
		task.setDue_date(cursor.getString(3));
		task.setCreator_id(cursor.getInt(4));
		
		return task;
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		
		// Enable foreign key constraints
        if (!database.isReadOnly()) {
        	database.execSQL("PRAGMA foreign_keys = ON;");
        }
		
	}

	public void close() {
		dbHelper.close();
	}
	
}




















