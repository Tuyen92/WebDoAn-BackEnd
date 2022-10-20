/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "diem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diem.findAll", query = "SELECT d FROM Diem d"),
    @NamedQuery(name = "Diem.findByMaTc", query = "SELECT d FROM Diem d WHERE d.diemPK.maTc = :maTc"),
    @NamedQuery(name = "Diem.findByDiem", query = "SELECT d FROM Diem d WHERE d.diem = :diem"),
    @NamedQuery(name = "Diem.findByNhanXet", query = "SELECT d FROM Diem d WHERE d.nhanXet = :nhanXet"),
    @NamedQuery(name = "Diem.findByGiangvienMaGv", query = "SELECT d FROM Diem d WHERE d.diemPK.giangvienMaGv = :giangvienMaGv"),
    @NamedQuery(name = "Diem.findByKhoaluanMaKl", query = "SELECT d FROM Diem d WHERE d.diemPK.khoaluanMaKl = :khoaluanMaKl"),
    @NamedQuery(name = "Diem.findByKhoaluanDangkykhoaluanMaDk", query = "SELECT d FROM Diem d WHERE d.diemPK.khoaluanDangkykhoaluanMaDk = :khoaluanDangkykhoaluanMaDk"),
    @NamedQuery(name = "Diem.findByKhoaluanDangkykhoaluanDetaiMaDt", query = "SELECT d FROM Diem d WHERE d.diemPK.khoaluanDangkykhoaluanDetaiMaDt = :khoaluanDangkykhoaluanDetaiMaDt")})
public class Diem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiemPK diemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private BigDecimal diem;
    @Size(max = 100)
    @Column(name = "nhan_xet")
    private String nhanXet;
    @JoinColumn(name = "giangvien_ma_gv", referencedColumnName = "ma_gv", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Giangvien giangvien;
    @JoinColumns({
        @JoinColumn(name = "khoaluan_ma_kl", referencedColumnName = "ma_kl", insertable = false, updatable = false),
        @JoinColumn(name = "khoaluan_dangkykhoaluan_ma_dk", referencedColumnName = "dangkykhoaluan_ma_dk", insertable = false, updatable = false),
        @JoinColumn(name = "khoaluan_dangkykhoaluan_detai_ma_dt", referencedColumnName = "dangkykhoaluan_detai_ma_dt", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Khoaluan khoaluan;
    @JoinColumn(name = "ma_tc", referencedColumnName = "ma_tc", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tieuchi tieuchi;

    public Diem() {
    }

    public Diem(DiemPK diemPK) {
        this.diemPK = diemPK;
    }

    public Diem(String maTc, String giangvienMaGv, int khoaluanMaKl, int khoaluanDangkykhoaluanMaDk, int khoaluanDangkykhoaluanDetaiMaDt) {
        this.diemPK = new DiemPK(maTc, giangvienMaGv, khoaluanMaKl, khoaluanDangkykhoaluanMaDk, khoaluanDangkykhoaluanDetaiMaDt);
    }

    public DiemPK getDiemPK() {
        return diemPK;
    }

    public void setDiemPK(DiemPK diemPK) {
        this.diemPK = diemPK;
    }

    public BigDecimal getDiem() {
        return diem;
    }

    public void setDiem(BigDecimal diem) {
        this.diem = diem;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public Giangvien getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(Giangvien giangvien) {
        this.giangvien = giangvien;
    }

    public Khoaluan getKhoaluan() {
        return khoaluan;
    }

    public void setKhoaluan(Khoaluan khoaluan) {
        this.khoaluan = khoaluan;
    }

    public Tieuchi getTieuchi() {
        return tieuchi;
    }

    public void setTieuchi(Tieuchi tieuchi) {
        this.tieuchi = tieuchi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diemPK != null ? diemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diem)) {
            return false;
        }
        Diem other = (Diem) object;
        if ((this.diemPK == null && other.diemPK != null) || (this.diemPK != null && !this.diemPK.equals(other.diemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Diem[ diemPK=" + diemPK + " ]";
    }
    
}
