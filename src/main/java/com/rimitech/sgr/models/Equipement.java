/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimitech.sgr.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "equipement")
@XmlRootElement

public class Equipement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num")
    private String num;
    @Column(name = "descr")
    private String descr;
    @Column(name = "sn")
    private String sn;
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "date_d_service")
    @Temporal(TemporalType.DATE)
    private Date dateDService;
    @Column(name = "date_f_service")
    @Temporal(TemporalType.DATE)
    private Date dateFService;
    @Column(name = "eta")
    private String eta;
    @Column(name = "type_alimentation")
    private String typeAlimentation;
    
   
    @OneToMany(mappedBy="num")
    private Collection<Vehicle> matricule;
    @JoinColumn(name = "structure", referencedColumnName = "id")
    @ManyToOne
    private Structure structure;
    
    
 
	public Equipement() {
		super();
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateDService() {
		return dateDService;
	}
	public void setDateDService(Date dateDService) {
		this.dateDService = dateDService;
	}
	public Date getDateFService() {
		return dateFService;
	}
	public void setDateFService(Date dateFService) {
		this.dateFService = dateFService;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getTypeAlimentation() {
		return typeAlimentation;
	}
	public void setTypeAlimentation(String typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}
	public Collection<Vehicle> getMatricule() {
		return matricule;
	}
	public void setMatricule(Collection<Vehicle> matricule) {
		this.matricule = matricule;
	}
	
    
}
