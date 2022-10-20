/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tongketkhoaluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tongketkhoaluan.findAll", query = "SELECT t FROM Tongketkhoaluan t"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaTk", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maTk = :maTk"),
    @NamedQuery(name = "Tongketkhoaluan.findByDiem", query = "SELECT t FROM Tongketkhoaluan t WHERE t.diem = :diem"),
    @NamedQuery(name = "Tongketkhoaluan.findByNam", query = "SELECT t FROM Tongketkhoaluan t WHERE t.nam = :nam"),
    @NamedQuery(name = "Tongketkhoaluan.findByKetQua", query = "SELECT t FROM Tongketkhoaluan t WHERE t.ketQua = :ketQua"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaNganh", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maNganh = :maNganh"),
    @NamedQuery(name = "Tongketkhoaluan.findByMaSv", query = "SELECT t FROM Tongketkhoaluan t WHERE t.maSv = :maSv")})
public class Tongketkhoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_tk")
    private Integer maTk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private BigDecimal diem;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @Size(max = 100)
    @Column(name = "ket_qua")
    private String ketQua;
    @Size(max = 10)
    @Column(name = "ma_nganh")
    private String maNganh;
    @Size(max = 10)
    @Column(name = "ma_sv")
    private String maSv;

    public Tongketkhoaluan() {
    }

    public Tongketkhoaluan(Integer maTk) {
        this.maTk = maTk;
    }

    public Integer getMaTk() {
        return maTk;
    }

    public void setMaTk(Integer maTk) {
        this.maTk = maTk;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTk != null ? maTk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tongketkhoaluan)) {
            return false;
        }
        Tongketkhoaluan other = (Tongketkhoaluan) object;
        if ((this.maTk == null && other.maTk != null) || (this.maTk != null && !this.maTk.equals(other.maTk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Tongketkhoaluan[ maTk=" + maTk + " ]";
    }
    
}
