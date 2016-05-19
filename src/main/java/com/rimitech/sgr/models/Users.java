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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nni")
    private String nni;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade =  CascadeType.REMOVE)
    @JoinTable(name = "user_role",  joinColumns = { 
            @JoinColumn(name = "nni", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false) })
    private Collection<Role> roles;
    
    @ManyToMany(cascade =  CascadeType.REMOVE)
    @JoinTable(
        name="user_vehicle",
        joinColumns=@JoinColumn(name="nni", referencedColumnName="nni"),
        inverseJoinColumns=@JoinColumn(name="matricule", referencedColumnName="matricule"))
    private Collection<Vehicle> VehicleCollection;
  
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "lastlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    
    @ManyToOne()
    private Structure structure;


	public Users() {
		
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public Collection<Vehicle> getVehicleCollection() {
		return VehicleCollection;
	}

	public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
		VehicleCollection = vehicleCollection;
	}

	public String getNni() {
		return nni;
	}

	public void setNni(String nni) {
		this.nni = nni;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}


    
}
