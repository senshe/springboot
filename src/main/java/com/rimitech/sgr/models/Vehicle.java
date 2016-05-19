package com.rimitech.sgr.models;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "descr")
    private String descr;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @Column(name = "date_d_suivi")
    @Temporal(TemporalType.DATE)
    private Date dateDSuivi;
    @Basic(optional = false)
    @Column(name = "date_f_suivi")
    @Temporal(TemporalType.DATE)
    private Date dateFSuivi;
    @Column(name = "motif")
    private String motif;
    @Id
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "type")
    private String type;
    @Column(name = "proprietaire")
    private String proprietaire;
    @OneToMany(mappedBy = "matricule")
    private Collection<Suivi> suiviCollection;

    @JoinColumn(name = "num")
    @ManyToOne
    private Equipement num;
   // @ManyToMany(mappedBy = "VehicleCollection")
   // private Collection<Users> users;
    
    
public Vehicle() {
	}
//public Collection<Users> getUsers() {
//		return users;
//	}
//	public void setUsers(Collection<Users> users) {
	//	this.users = users;
	//}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateDSuivi() {
		return dateDSuivi;
	}
	public void setDateDSuivi(Date dateDSuivi) {
		this.dateDSuivi = dateDSuivi;
	}
	public Date getDateFSuivi() {
		return dateFSuivi;
	}
	public void setDateFSuivi(Date dateFSuivi) {
		this.dateFSuivi = dateFSuivi;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Collection<Suivi> getSuiviCollection() {
		return suiviCollection;
	}
	public void setSuiviCollection(Collection<Suivi> suiviCollection) {
		this.suiviCollection = suiviCollection;
	}
	public Equipement getNum() {
		return num;
	}
	public void setNum(Equipement num) {
		this.num = num;
	}
   

	
    
}
