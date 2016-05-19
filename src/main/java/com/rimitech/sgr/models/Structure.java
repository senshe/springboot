/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimitech.sgr.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "structure")
public class Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "descr")
    private String descr;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "structure",cascade =  CascadeType.REMOVE)
    private Collection<Equipement> equipements;
    @OneToMany(mappedBy = "structure",cascade =  CascadeType.REMOVE)
    private Collection<Users> users;
    @Column(name = "type")
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Structure() {
    }

    public Structure(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(Collection<Equipement> equipementCollection) {
        this.equipements = equipementCollection;
    }

    @XmlTransient
    public Collection<Users> getUsers() {
        return users;
    }

    public void setUsers(Collection<Users> UserssCollection) {
        this.users = UserssCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Structure)) {
            return false;
        }
        Structure other = (Structure) object;
        if ((this.id == null && other.id != null) || (this.id!= null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Structure[ id=" + id + " ]";
    }
    
}
