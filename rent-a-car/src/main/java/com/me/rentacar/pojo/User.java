package com.me.rentacar.pojo;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.OneToOne;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "userid")
public class User extends Person {
	
	

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "userrole")
	private String userrole;
	
	public User(){
	}

	public User(String username, String password, String userrole) {
		this.username = username;
		this.password = password;
		this.userrole = userrole;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	
	
	
	
	
	
	


}
