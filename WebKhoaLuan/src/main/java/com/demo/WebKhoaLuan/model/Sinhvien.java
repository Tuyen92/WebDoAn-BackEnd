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
@Table(name = "sinhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s"),
    @NamedQuery(name = "Sinhvien.findByMaSv", query = "SELECT s FROM Sinhvien s WHERE s.maSv = :maSv"),
    @NamedQuery(name = "Sinhvien.findByNienKhoa", query = "SELECT s FROM Sinhvien s WHERE s.nienKhoa = :nienKhoa"),
    @NamedQuery(name = "Sinhvien.findByTinhTrang", query = "SELECT s FROM Sinhvien s WHERE s.tinhTrang = :tinhTrang")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_sv")
    private String maSv;
    @Size(max = 20)
    @Column(name = "nien_khoa")
    private String nienKhoa;
    @Column(name = "tinh_trang")
    private Short tinhTrang;
    @JoinColumns({
        @JoinColumn(name = "nganh_ma_nganh", referencedColumnName = "ma_nganh"),
        @JoinColumn(name = "nganh_khoa_ma_khoa", referencedColumnName = "khoa_ma_khoa")})
    @ManyToOne(optional = false)
    private Nganh nganh;
    @JoinColumns({
        @JoinColumn(name = "nguoidung_ma_nd", referencedColumnName = "ma_nd"),
        @JoinColumn(name = "nguoidung_chucvu_ma_cv", referencedColumnName = "chucvu_ma_cv")})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Sinhvien() {
    }

    public Sinhvien(String maSv) {
        this.maSv = maSv;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public Short getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Short tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
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
        hash += (maSv != null ? maSv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.maSv == null && other.maSv != null) || (this.maSv != null && !this.maSv.equals(other.maSv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Sinhvien[ maSv=" + maSv + " ]";
    }
    
}
