/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@JsonIgnoreProperties({"giangvien"})
@Entity
@Table(name = "chitiethoidong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiethoidong.findAll", query = "SELECT c FROM Chitiethoidong c"),
    @NamedQuery(name = "Chitiethoidong.findByMaGv", query = "SELECT c FROM Chitiethoidong c WHERE c.chitiethoidongPK.maGv = :maGv"),
    @NamedQuery(name = "Chitiethoidong.findByMaHd", query = "SELECT c FROM Chitiethoidong c WHERE c.chitiethoidongPK.maHd = :maHd"),
    @NamedQuery(name = "Chitiethoidong.findByChucVuhd", query = "SELECT c FROM Chitiethoidong c WHERE c.chucVuhd = :chucVuhd")})
public class Chitiethoidong implements Serializable {

    @Size(max = 45)
    @Column(name = "chuc_vuhd")
    private String chucVuhd;
    @JoinColumn(name = "giangvien_ma_gv", referencedColumnName = "ma_gv", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Giangvien giangvien;
    @JoinColumn(name = "hoidong_ma_hd", referencedColumnName = "ma_hd", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hoidong hoidong;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitiethoidongPK chitiethoidongPK;
   
    public Chitiethoidong() {
    }

    public Chitiethoidong(ChitiethoidongPK chitiethoidongPK) {
        this.chitiethoidongPK = chitiethoidongPK;
    }

    public Chitiethoidong(String maGv, int maHd) {
        this.chitiethoidongPK = new ChitiethoidongPK(maGv, maHd);
    }

    public ChitiethoidongPK getChitiethoidongPK() {
        return chitiethoidongPK;
    }

    public void setChitiethoidongPK(ChitiethoidongPK chitiethoidongPK) {
        this.chitiethoidongPK = chitiethoidongPK;
    }

    public String getChucVuhd() {
        return chucVuhd;
    }

    public void setChucVuhd(String chucVuhd) {
        this.chucVuhd = chucVuhd;
    }

    public Giangvien getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(Giangvien giangvien) {
        this.giangvien = giangvien;
    }

    public Hoidong getHoidong() {
        return hoidong;
    }

    public void setHoidong(Hoidong hoidong) {
        this.hoidong = hoidong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitiethoidongPK != null ? chitiethoidongPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiethoidong)) {
            return false;
        }
        Chitiethoidong other = (Chitiethoidong) object;
        if ((this.chitiethoidongPK == null && other.chitiethoidongPK != null) || (this.chitiethoidongPK != null && !this.chitiethoidongPK.equals(other.chitiethoidongPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Chitiethoidong[ chitiethoidongPK=" + chitiethoidongPK + " ]";
    }    
}
