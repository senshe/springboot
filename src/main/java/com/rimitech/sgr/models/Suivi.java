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
import org.hibernate.annotations.Type;
import org.json.JSONObject;
import org.wololo.jts2geojson.GeoJSONWriter;

import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author ElBastamy
 */
@Entity
@Table(name = "suivi")
public class Suivi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Type(type="org.hibernate.spatial.GeometryType")
    @Column(name = "posistion")
	private Geometry posistion;
	@Column(name = "descr")
    private String descr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vitess")
    private Float vitess;
    @Column(name = "altitude")
    private Float altitude;
    @Basic(optional = false)
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Column(name = "eta")
    private String eta;
   
    @ManyToOne
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Vehicle matricule;

    public Suivi() {
    }

    public Suivi(Integer id) {
        this.id = id;
    }

    public Suivi(Integer id, Date dateTime) {
        this.id = id;
        this.dateTime = dateTime;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public Vehicle getMatricule() {
        return matricule;
    }

    public void setMatricule(Vehicle matricule) {
        this.matricule = matricule;
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
        if (!(object instanceof Suivi)) {
            return false;
        }
        Suivi other = (Suivi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Suivi[ id=" + id + " ]";
    }
    public Geometry getPosistion() {
		return posistion;
	}

	public void setPosistion(Geometry posistion) {
		this.posistion = posistion;
	}
	public JSONObject getJson() {
		
		JSONObject gjo=new JSONObject();
		String mat=" ";
		if(this.posistion!=null&&this.matricule!=null){
			gjo=new JSONObject(new GeoJSONWriter().write(this.posistion).toString());
			mat=matricule.getMatricule();
		}
		
		return new JSONObject()
				.put("type", "Feature")
				.put("geometry",gjo)
				.put("properties",
						new JSONObject()
							.put("code", this.id)
							.put("descr", this.descr)
							.put("vitess", vitess)
							.put("id",mat)
							.put("eta", eta)
							.put("dateTime", dateTime)
							.put("altitude",altitude)
						
						);
	}
}























