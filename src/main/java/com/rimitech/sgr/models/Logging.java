/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rimitech.sgr.models;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "logging")
public class Logging implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descr")
    private String descr;
    @Column(name = "table_op")
    private String tableOp;
    @Column(name = "date_op")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOp;
    @Column(name = "opperation")
    private String opperation;
    @JoinColumn(name = "nni", referencedColumnName = "nni")
    @ManyToOne(optional = false)
    private Users nni;

    public Logging() {
    }

    public Logging(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getTableOp() {
        return tableOp;
    }

    public void setTableOp(String tableOp) {
        this.tableOp = tableOp;
    }

    public Date getDateOp() {
        return dateOp;
    }

    public void setDateOp(Date dateOp) {
        this.dateOp = dateOp;
    }

    public String getOpperation() {
        return opperation;
    }

    public void setOpperation(String opperation) {
        this.opperation = opperation;
    }

    public Users getNni() {
        return nni;
    }

    public void setNni(Users nni) {
        this.nni = nni;
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
        if (!(object instanceof Logging)) {
            return false;
        }
        Logging other = (Logging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Logging[ id=" + id + " ]";
    }
    
}
