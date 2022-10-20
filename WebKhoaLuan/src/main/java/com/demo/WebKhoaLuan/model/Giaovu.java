/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "giaovu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giaovu.findAll", query = "SELECT g FROM Giaovu g"),
    @NamedQuery(name = "Giaovu.findByMaGvu", query = "SELECT g FROM Giaovu g WHERE g.maGvu = :maGvu"),
    @NamedQuery(name = "Giaovu.findByPhongBan", query = "SELECT g FROM Giaovu g WHERE g.phongBan = :phongBan")})
public class Giaovu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_gvu")
    private String maGvu;
    @Size(max = 50)
    @Column(name = "phong_ban")
    private String phongBan;
    @JoinColumns({
        @JoinColumn(name = "nguoidung_ma_nd", referencedColumnName = "ma_nd"),
        @JoinColumn(name = "nguoidung_chucvu_ma_cv", referencedColumnName = "chucvu_ma_cv")})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Giaovu() {
    }

    public Giaovu(String maGvu) {
        this.maGvu = maGvu;
    }

    public String getMaGvu() {
        return maGvu;
    }

    public void setMaGvu(String maGvu) {
        this.maGvu = maGvu;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGvu != null ? maGvu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giaovu)) {
            return false;
        }
        Giaovu other = (Giaovu) object;
        if ((this.maGvu == null && other.maGvu != null) || (this.maGvu != null && !this.maGvu.equals(other.maGvu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Giaovu[ maGvu=" + maGvu + " ]";
    }
    
}
