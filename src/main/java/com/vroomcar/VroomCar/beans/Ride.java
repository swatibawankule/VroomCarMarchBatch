package com.vroomcar.VroomCar.beans;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "RIDE")
public class Ride {

	@Id
	@GeneratedValue
	@Column(name = "rideid", unique = true, nullable = false)
	private Integer rideid;

	public Ride(Integer rideid, Double pricePerTraveller, Integer riderAge, String riderName, String carType,
			Integer seats, String source, String destination, String desc, String departureDateString,
			Boolean homepickup, String insuranceStatus, Integer userId, String imageUrl, Date departureDate,
			Long distanceTravelled) {
		super();
		this.rideid = rideid;
		this.pricePerTraveller = pricePerTraveller;
		this.riderAge = riderAge;
		this.riderName = riderName;
		this.carType = carType;
		this.seats = seats;
		this.source = source;
		this.destination = destination;
		this.desc = desc;
		this.departureDateString = departureDateString;
		this.homepickup = homepickup;
		this.insuranceStatus = insuranceStatus;
		this.userId = userId;
		this.imageUrl = imageUrl;
		this.departureDate = departureDate;
		this.distanceTravelled = distanceTravelled;
	}

	public Ride() {
		// TODO Auto-generated constructor stub
	}

	


	public Ride(Integer rideid, Integer riderAge, String riderName, String source, String destination, Integer userId) {
		super();
		this.rideid = rideid;
		this.riderAge = riderAge;
		this.riderName = riderName;
		this.source = source;
		this.destination = destination;
		this.userId = userId;
	}

	public void setRideid(Integer rideid) {
		this.rideid = rideid;
	}


	@Column(name = "pricePerTraveller", unique = false, length = 100)
	private Double pricePerTraveller;

	@Column(name = "riderAge",length = 100)
	private Integer riderAge;


	@Column(name = "riderName", unique = false, length = 100)
	private String riderName;


	@Column(name = "carType", unique = false, length = 100)
	private String carType;

	@Column(name = "seats", unique = false, length = 100)
	private Integer seats;

	@Column(name = "source", unique = false, length = 100)
	private String source;

	@Column(name = "destination", unique = false, length = 100)
	private String destination;
	
	@Column(name = "description", unique = false, length = 400)
	private String desc;

	@Column
	private String departureDateString;
	
	@Column(name = "homepickup", unique = false, length = 100)
	private Boolean homepickup;
	
	@Column(name = "insuranceStatus", unique = false, length = 100)
	private String insuranceStatus;

	@Column
	private Integer userId;
	
	@Column
	private String imageUrl;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	
	@Column(name = "distanceTravelled", unique = false, length = 50)
	private Long distanceTravelled;
	
	
	public Long getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(Long distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public Boolean getHomepickup() {
		return homepickup;
	}

	public void setHomepickup(Boolean homepickup) {
		this.homepickup = homepickup;
	}

	public String getDepartureDateString() {
		return departureDateString;
	}

	public void setDepartureDateString(String departureDateString) {
		this.departureDateString = departureDateString;
	}


	
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	

	public Date getDepartureDate() {
		return departureDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		imageUrl = ImageUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer UserId) {
		userId = UserId;
	}

	public Integer getRiderAge() {
		return riderAge;
	}

	public void setRiderAge(Integer riderAge) {
		this.riderAge = riderAge;
	}
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDesc() {
		return desc;
	}

	public void setDesc(String description) {
		this.desc = description;
	}

	public Integer getRideid() {
		return rideid;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seat) {
		seats = seat;
	}


	public Double getPricePerTraveller() {
		return pricePerTraveller;
	}

	public void setPricePerTraveller(Double pricePerTraveller) {
		this.pricePerTraveller = pricePerTraveller;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	@Override
	public String toString() {
		return "Ride [rideid=" + rideid + 
				 " pricePerTraveller=" + pricePerTraveller + ", riderAge="
				+ riderAge + ", riderName=" + riderName + ", carType=" + carType + ", Seats=" + seats
				+ ", source=" + source + ", Desc=" + desc + ", Destination="
				+ destination + ", DepartureDate=" + departureDate + "]";
	}
	
}
