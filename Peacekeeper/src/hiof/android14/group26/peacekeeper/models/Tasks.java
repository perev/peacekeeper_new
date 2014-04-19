package hiof.android14.group26.peacekeeper.models;

public class Tasks {
	private int id, creator_id, responsible_id;
	private String description, creation_date, due_date;
	//TODO: change strings with date?
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	public int getResponsible_id() {
		return responsible_id;
	}
	public void setResponsible_id(int responsible_id) {
		this.responsible_id = responsible_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
	
}
