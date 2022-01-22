package com.me.rentacar.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Email;


@Entity
@Table(name= "person")
@Inheritance(strategy=InheritanceType.JOINED)

public class Person {
	@Id
	@GeneratedValue
	@Column(name="userid",unique=true,nullable=false)
	private long userid;
	
	@NotBlank(message = " * Your first name can't be blank")
	@Size(min = 3, max = 15, message = " * Your first name shoud have atleast 3 char")
	@Pattern(regexp = "^[a-zA-Z\s]*$", message = "Your first name can contain only alphabets")
	@Column(name="firstname",nullable=false)
	private String firstname;
	
	@NotBlank(message = " * Your Last name can't be blank")
	@Size(min = 3, max = 15, message = " * Your Last name shoud have atleast 3 char")
	@Pattern(regexp = "^[a-zA-Z\s]*$", message = "Your first name can contain only alphabets")
	@Column(name="lastname",nullable=false)
	private String lastname;
	
	@NotBlank(message = " * Your phone number name can't be blank")
	@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = " * Your phone number has incorrect format")
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name="address")
	private String address;
	
	@Email(message = "Email should be valid")
	@Column(name="emailId",nullable=false)
	private String emailId;
	
	@Min(value = 18, message = "Age should not be less than 18")
	@Column(name="age",length=2,nullable=false)
	private int age;
	
public Person(){
		
	}

	

	public Person(long userid, String firstname, String lastname, String phonenumber, String address, String emailId,
			int age) {

		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.emailId = emailId;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	

}
