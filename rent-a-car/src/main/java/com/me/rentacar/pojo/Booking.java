package com.me.rentacar.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table (name = "booking")
public class Booking {

	@Id
	@GeneratedValue
	@Column (name = "booking_id",unique=true,nullable=false)
	private int booking_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
    private User userid;
	
	@Column (name = "bookedFrom")
	private String bookedFrom;
	
	@Column (name = "bookedTill")
	private String bookedTill;
	
	@Column (name = "status")
	private String status;
	
	@Column (name = "carid")
	private int carid;
	

	
	public Booking() {
		
	}



	public Booking(int booking_id, User userid, String bookedFrom, String bookedTill, String status, int carid) {
	
		this.booking_id = booking_id;
		this.userid = userid;
		this.bookedFrom = bookedFrom;
		this.bookedTill = bookedTill;
		this.status = status;
		this.carid = carid;
	}



	public int getBooking_id() {
		return booking_id;
	}



	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}



	public User getUserid() {
		return userid;
	}



	public void setUserid(User userid) {
		this.userid = userid;
	}



	public String getBookedFrom() {
		return bookedFrom;
	}



	public void setBookedFrom(String bookedFrom) {
		this.bookedFrom = bookedFrom;
	}



	public String getBookedTill() {
		return bookedTill;
	}



	public void setBookedTill(String bookedTill) {
		this.bookedTill = bookedTill;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getCarid() {
		return carid;
	}



	public void setCarid(int carid) {
		this.carid = carid;
	}



	
	
	
}
