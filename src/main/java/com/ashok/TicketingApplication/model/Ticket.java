package com.ashok.TicketingApplication.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	private int id;
	private String type;
	private String description;
	private String title;
	private int createdBy;
	private int customerid;
	private int assigneduser;
	private int priority;
	private String status;
	private String comments;
	
	public Ticket(){
		
	}
	
	
	public Ticket(int id, String type, String description, String title, int createdBy, int customerid,
			int assigneduser, int priority, String status, String comments) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.title = title;
		this.createdBy = createdBy;
		this.customerid = customerid;
		this.assigneduser = assigneduser;
		this.priority = priority;
		this.status = status;
		this.comments = comments;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="title")
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	
	@Column(name="createdby")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="customerid")
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	@Column(name="assigneduser")
	public int getAssigneduser() {
		return assigneduser;
	}
	public void setAssigneduser(int assigneduser) {
		this.assigneduser = assigneduser;
	}
	
	@Column(name="priority")
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", type=" + type + ", description=" + description + ", title=" + title
				+ ", createdBy=" + createdBy + ", customerid=" + customerid + ", assigneduser=" + assigneduser
				+ ", priority=" + priority + ", status=" + status + ", comments=" + comments + "]";
	}


}

