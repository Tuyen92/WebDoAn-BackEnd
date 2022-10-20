/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@JsonIgnoreProperties({"khoaluanSet", "chitiethoidongSet"})
@Entity
@Table(name = "hoidong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoidong.findAll", query = "SELECT h FROM Hoidong h"),
    @NamedQuery(name = "Hoidong.findByMaHd", query = "SELECT h FROM Hoidong h WHERE h.maHd = :maHd"),
    @NamedQuery(name = "Hoidong.findByTenHd", query = "SELECT h FROM Hoidong h WHERE h.tenHd = :tenHd"),
    @NamedQuery(name = "Hoidong.findByNgayLap", query = "SELECT h FROM Hoidong h WHERE h.ngayLap = :ngayLap"),
    @NamedQuery(name = "Hoidong.findByTinhTranghd", query = "SELECT h FROM Hoidong h WHERE h.tinhTranghd = :tinhTranghd")})
public class Hoidong implements Serializable {

    @Size(max = 200)
    @Column(name = "ten_hd")
    private String tenHd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoidong")
    private Set<Chitiethoidong> chitiethoidongSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_hd")
    private Integer maHd;
    @Column(name = "ngay_lap")
    @Temporal(TemporalType.DATE)
    private Date ngayLap;
    @Column(name = "tinh_tranghd")
    private Short tinhTranghd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoidongMaHd")
    private Set<Khoaluan> khoaluanSet;

    public Hoidong() {
    }

    public Hoidong(Integer maHd) {
        this.maHd = maHd;
    }

    public Integer getMaHd() {
        return maHd;
    }

    public void setMaHd(Integer maHd) {
        this.maHd = maHd;
    }

    public String getTenHd() {
        return tenHd;
    }

    public void setTenHd(String tenHd) {
        this.tenHd = tenHd;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Short getTinhTranghd() {
        return tinhTranghd;
    }

    public void setTinhTranghd(Short tinhTranghd) {
        this.tinhTranghd = tinhTranghd;
    }

//    public Chitiethoidong getChitiethoidong() {
//        return chitiethoidong;
//    }
//
//    public void setChitiethoidong(Chitiethoidong chitiethoidong) {
//        this.chitiethoidong = chitiethoidong;
//    }
//
    @XmlTransient
    public Set<Khoaluan> getKhoaluanSet() {
        return khoaluanSet;
    }

    public void setKhoaluanSet(Set<Khoaluan> khoaluanSet) {
        this.khoaluanSet = khoaluanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHd != null ? maHd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoidong)) {
            return false;
        }
        Hoidong other = (Hoidong) object;
        if ((this.maHd == null && other.maHd != null) || (this.maHd != null && !this.maHd.equals(other.maHd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Hoidong[ maHd=" + maHd + " ]";
    }

    @XmlTransient
    public Set<Chitiethoidong> getChitiethoidongSet() {
        return chitiethoidongSet;
    }

    public void setChitiethoidongSet(Set<Chitiethoidong> chitiethoidongSet) {
        this.chitiethoidongSet = chitiethoidongSet;
    }
    
}
