package com.me.rentacar.pojo;

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
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Email;
import javax.persistence.ManyToMany;

import com.me.rentacar.pojo.Location;

@Entity
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue( strategy =GenerationType.AUTO)
	@Column (name="carid",unique=true,nullable=false)
	private int carid;
    
	@NotBlank(message = " * Car Number Plate can't be Null")
	@Size(min = 3, max = 8, message = " * Number Plate should be atleast 3 to max 8 char ")
	@Column(name="carnumplate")
	private String carnumplate;
	
	@Size(min = 3, max = 10, message = " * Car Name should be atleast 3 to max 10 char ")
	@Column(name="carname")
	private String carname;
	
	@Column(name="perhourrate")
	private float perhourrate;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name = "yearofmanufacture", nullable = false)
	private int yearofmanufacture;
	
	@Column (name = "rating")
	private String rating;
	
	@Column (name = "milageinmiles")
	private float milageinmiles;
	
	@Size(min = 3, max = 10, message = " * Car Brand should be atleast 3 to max 10 char ")
	@Column (name = "carbrand")
	private String carbrand;
	

	@Column (name = "noofseats")
	private int noofseats;
	
	
	@PrimaryKeyJoinColumn(name="location_id")
    private int location_id;
	


	

	public Car() {
		
		// TODO Auto-generated constructor stub
	}

	
	

	public Car( String carnumplate, String carname, float perhourrate, String availability,
			int yearofmanufacture, String rating, float milageinmiles, String carbrand, int noofseats,
			int location_id) {
		

		this.carnumplate = carnumplate;
		this.carname = carname;
		this.perhourrate = perhourrate;
		this.availability = availability;
		this.yearofmanufacture = yearofmanufacture;
		this.rating = rating;
		this.milageinmiles = milageinmiles;
		this.carbrand = carbrand;
		this.noofseats = noofseats;
		this.location_id = location_id;
	}




	public int getCarid() {
		return carid;
	}




	public void setCarid(int carid) {
		this.carid = carid;
	}




	public String getCarnumplate() {
		return carnumplate;
	}




	public void setCarnumplate(String carnumplate) {
		this.carnumplate = carnumplate;
	}




	public String getCarname() {
		return carname;
	}




	public void setCarname(String carname) {
		this.carname = carname;
	}




	public float getPerhourrate() {
		return perhourrate;
	}




	public void setPerhourrate(float perhourrate) {
		this.perhourrate = perhourrate;
	}




	public String getAvailability() {
		return availability;
	}




	public void setAvailability(String availability) {
		this.availability = availability;
	}




	public int getYearofmanufacture() {
		return yearofmanufacture;
	}




	public void setYearofmanufacture(int yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}




	public String getRating() {
		return rating;
	}




	public void setRating(String rating) {
		this.rating = rating;
	}




	public float getMilageinmiles() {
		return milageinmiles;
	}




	public void setMilageinmiles(float milageinmiles) {
		this.milageinmiles = milageinmiles;
	}




	public String getCarbrand() {
		return carbrand;
	}




	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}




	public int getNoofseats() {
		return noofseats;
	}




	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}




	public int getLocation_id() {
		return location_id;
	}




	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}




	

}
