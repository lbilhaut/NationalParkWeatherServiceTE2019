package com.techelevator.npgeek.model;

import java.util.List;


public class Park {

	
	private String parkcode;
	private String parkcodeInLowerCase;
	private String parkname;
	private String state;
	private int acreage;
	private int elevationinfeet;
	private float milesoftrail;
	private int numberofcampsites;
	private String climate;
	private int yearfounded;
	private int annualvisitorcount;
	private String inspirationalquote;
	private String inspirationalquotesource;
	private String parkdescription;
	private int entryfee;
	private int numberofanimalspecies;

	private List<DayForecast> forecastFor5Days;

	// Getters and setters
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevationinfeet() {
		return elevationinfeet;
	}
	public void setElevationinfeet(int elevationinfeet) {
		this.elevationinfeet = elevationinfeet;
	}
	public float getMilesoftrail() {
		return milesoftrail;
	}
	public void setMilesoftrail(float milesoftrail) {
		this.milesoftrail = milesoftrail;
	}
	public int getNumberofcampsites() {
		return numberofcampsites;
	}
	public void setNumberofcampsites(int numberofcampsites) {
		this.numberofcampsites = numberofcampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearfounded() {
		return yearfounded;
	}
	public void setYearfounded(int yearfounded) {
		this.yearfounded = yearfounded;
	}
	public int getAnnualvisitorcount() {
		return annualvisitorcount;
	}
	public void setAnnualvisitorcount(int annualvisitorcount) {
		this.annualvisitorcount = annualvisitorcount;
	}
	public String getInspirationalquote() {
		return inspirationalquote;
	}
	public void setInspirationalquote(String inspirationalquote) {
		this.inspirationalquote = inspirationalquote;
	}
	public String getInspirationalquotesource() {
		return inspirationalquotesource;
	}
	public void setInspirationalquotesource(String inspirationalquotesource) {
		this.inspirationalquotesource = inspirationalquotesource;
	}
	public String getParkdescription() {
		return parkdescription;
	}
	public void setParkdescription(String parkdescription) {
		this.parkdescription = parkdescription;
	}
	public int getEntryfee() {
		return entryfee;
	}
	public void setEntryfee(int entryfee) {
		this.entryfee = entryfee;
	}
	public int getNumberofanimalspecies() {
		return numberofanimalspecies;
	}
	public void setNumberofanimalspecies(int numberofanimalspecies) {
		this.numberofanimalspecies = numberofanimalspecies;
	}
	
	public String getParkcodeInLowerCase() {
		return parkcode.toLowerCase();
		}
	
	public void setParkcodeInLowerCase(String parkcodeInLowerCase) {
		this.parkcodeInLowerCase = parkcodeInLowerCase;
	}


	
	
	

}
