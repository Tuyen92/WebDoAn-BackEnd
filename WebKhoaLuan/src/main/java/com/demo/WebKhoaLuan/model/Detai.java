/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@JsonIgnoreProperties({"dangkykhoaluanSet"})
@Entity
@Table(name = "detai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detai.findAll", query = "SELECT d FROM Detai d"),
    @NamedQuery(name = "Detai.findByMaDt", query = "SELECT d FROM Detai d WHERE d.maDt = :maDt"),
    @NamedQuery(name = "Detai.findByTenDt", query = "SELECT d FROM Detai d WHERE d.tenDt = :tenDt"),
    @NamedQuery(name = "Detai.findByNoiDunngdt", query = "SELECT d FROM Detai d WHERE d.noiDunngdt = :noiDunngdt"),
    @NamedQuery(name = "Detai.findByHanNop", query = "SELECT d FROM Detai d WHERE d.hanNop = :hanNop")})
public class Detai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_dt")
    private Integer maDt;
    @Size(max = 45)
    @Column(name = "ten_dt")
    private String tenDt;
    @Size(max = 45)
    @Column(name = "noi_dunngdt")
    private String noiDunngdt;
    @Size(max = 45)
    @Column(name = "han_nop")
    private String hanNop;
    @JoinColumn(name = "khoa_ma_khoa", referencedColumnName = "ma_khoa")
    @ManyToOne(optional = false)
    private Khoa khoaMaKhoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detai")
    private Set<Dangkykhoaluan> dangkykhoaluanSet;

    public Detai() {
    }

    public Detai(Integer maDt) {
        this.maDt = maDt;
    }

    public Integer getMaDt() {
        return maDt;
    }

    public void setMaDt(Integer maDt) {
        this.maDt = maDt;
    }

    public String getTenDt() {
        return tenDt;
    }

    public void setTenDt(String tenDt) {
        this.tenDt = tenDt;
    }

    public String getNoiDunngdt() {
        return noiDunngdt;
    }

    public void setNoiDunngdt(String noiDunngdt) {
        this.noiDunngdt = noiDunngdt;
    }

    public String getHanNop() {
        return hanNop;
    }

    public void setHanNop(String hanNop) {
        this.hanNop = hanNop;
    }

    public Khoa getKhoaMaKhoa() {
        return khoaMaKhoa;
    }

    public void setKhoaMaKhoa(Khoa khoaMaKhoa) {
        this.khoaMaKhoa = khoaMaKhoa;
    }

    @XmlTransient
    public Set<Dangkykhoaluan> getDangkykhoaluanSet() {
        return dangkykhoaluanSet;
    }

    public void setDangkykhoaluanSet(Set<Dangkykhoaluan> dangkykhoaluanSet) {
        this.dangkykhoaluanSet = dangkykhoaluanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDt != null ? maDt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detai)) {
            return false;
        }
        Detai other = (Detai) object;
        if ((this.maDt == null && other.maDt != null) || (this.maDt != null && !this.maDt.equals(other.maDt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Detai[ maDt=" + maDt + " ]";
    }
    
}
