package com.me.rentacar.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;



import com.me.rentacar.pojo.Car;


@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue( strategy =GenerationType.AUTO)
	@Column (name="location_id",unique=true,nullable=false)
	private int location_id;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="location_id")
	private Set<Car> cars = new HashSet<Car>();
	
	@NotBlank(message = " * State can't be blank")
	@Size(min = 2, max = 3, message = "State must be between 2 and 3 characters")
	@Column(name="state",nullable=false)
	private String state;
	
	@NotBlank(message = " * City can't be blank")
	@Size(min = 3, max = 15, message = "City must be between 3 and 15 characters")
	@Column(name="city",nullable=false)
	private String city;
	
	
	
	

	public Location() {
	
		// TODO Auto-generated constructor stub
	}
	
	

	public Location(int location_id, Set<Car> cars, String state, String city) {
		
		this.location_id = location_id;
		this.cars = cars;
		this.state = state;
		this.city = city;
	}



	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	
	
	
	
	
}
