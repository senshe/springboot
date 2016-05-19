package com.rimitech.sgr.dto;

import java.util.Date;

public class SuiviDto {
	
	private String lat;
	private String lon;
	private String expediteur;
    private String descr;
    private Float vitess;
    private Float altitude;
    private String dateTime;
    private String eta;
    
    
	public SuiviDto() {
		
	}
	
	public SuiviDto(String lat, String lon, String expediteur, String descr, Float vitess, Float altitude,
			String dateTime, String eta) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.expediteur = expediteur;
		this.descr = descr;
		this.vitess = vitess;
		this.altitude = altitude;
		this.dateTime = dateTime;
		this.eta = eta;
	}

	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Float getVitess() {
		return vitess;
	}
	public void setVitess(Float vitess) {
		this.vitess = vitess;
	}
	public Float getAltitude() {
		return altitude;
	}
	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
    
}
