/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@JsonIgnoreProperties({"diemSet"})
@Entity
@Table(name = "khoaluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khoaluan.findAll", query = "SELECT k FROM Khoaluan k"),
    @NamedQuery(name = "Khoaluan.findByMaKl", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maKl = :maKl"),
    @NamedQuery(name = "Khoaluan.findByNam", query = "SELECT k FROM Khoaluan k WHERE k.nam = :nam"),
    @NamedQuery(name = "Khoaluan.findByGhiChu", query = "SELECT k FROM Khoaluan k WHERE k.ghiChu = :ghiChu"),
    @NamedQuery(name = "Khoaluan.findByNgayNop", query = "SELECT k FROM Khoaluan k WHERE k.ngayNop = :ngayNop"),
    @NamedQuery(name = "Khoaluan.findByMaSv2", query = "SELECT k FROM Khoaluan k WHERE k.maSv2 = :maSv2"),
    @NamedQuery(name = "Khoaluan.findByMaGvhd", query = "SELECT k FROM Khoaluan k WHERE k.maGvhd = :maGvhd"),
    @NamedQuery(name = "Khoaluan.findByMaGvpb", query = "SELECT k FROM Khoaluan k WHERE k.maGvpb = :maGvpb"),
    @NamedQuery(name = "Khoaluan.findByFileNop", query = "SELECT k FROM Khoaluan k WHERE k.fileNop = :fileNop"),
    @NamedQuery(name = "Khoaluan.findByDangkykhoaluanMaDk", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.dangkykhoaluanMaDk = :dangkykhoaluanMaDk"),
    @NamedQuery(name = "Khoaluan.findByDangkykhoaluanDetaiMaDt", query = "SELECT k FROM Khoaluan k WHERE k.khoaluanPK.dangkykhoaluanDetaiMaDt = :dangkykhoaluanDetaiMaDt")})
public class Khoaluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KhoaluanPK khoaluanPK;
    @Size(max = 15)
    @Column(name = "nam")
    private String nam;
    @Size(max = 100)
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "ngay_nop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayNop;
    @Size(max = 10)
    @Column(name = "ma_sv2")
    private String maSv2;
    @Size(max = 10)
    @Column(name = "ma_gvhd")
    private String maGvhd;
    @Size(max = 10)
    @Column(name = "ma_gvpb")
    private String maGvpb;
    @Size(max = 100)
    @Column(name = "file_nop")
    private String fileNop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaluan")
    private Set<Diem> diemSet;
    @JoinColumns({
        @JoinColumn(name = "dangkykhoaluan_ma_dk", referencedColumnName = "ma_dk", insertable = false, updatable = false),
        @JoinColumn(name = "dangkykhoaluan_detai_ma_dt", referencedColumnName = "detai_ma_dt", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Dangkykhoaluan dangkykhoaluan;
    @JoinColumn(name = "hoidong_ma_hd", referencedColumnName = "ma_hd")
    @ManyToOne(optional = false)
    private Hoidong hoidongMaHd;

    public Khoaluan() {
    }

    public Khoaluan(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public Khoaluan(int maKl, int dangkykhoaluanMaDk, int dangkykhoaluanDetaiMaDt) {
        this.khoaluanPK = new KhoaluanPK(maKl, dangkykhoaluanMaDk, dangkykhoaluanDetaiMaDt);
    }

    public KhoaluanPK getKhoaluanPK() {
        return khoaluanPK;
    }

    public void setKhoaluanPK(KhoaluanPK khoaluanPK) {
        this.khoaluanPK = khoaluanPK;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public String getMaSv2() {
        return maSv2;
    }

    public void setMaSv2(String maSv2) {
        this.maSv2 = maSv2;
    }

    public String getMaGvhd() {
        return maGvhd;
    }

    public void setMaGvhd(String maGvhd) {
        this.maGvhd = maGvhd;
    }

    public String getMaGvpb() {
        return maGvpb;
    }

    public void setMaGvpb(String maGvpb) {
        this.maGvpb = maGvpb;
    }

    public String getFileNop() {
        return fileNop;
    }

    public void setFileNop(String fileNop) {
        this.fileNop = fileNop;
    }

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
    }

    public Dangkykhoaluan getDangkykhoaluan() {
        return dangkykhoaluan;
    }

    public void setDangkykhoaluan(Dangkykhoaluan dangkykhoaluan) {
        this.dangkykhoaluan = dangkykhoaluan;
    }

    public Hoidong getHoidongMaHd() {
        return hoidongMaHd;
    }

    public void setHoidongMaHd(Hoidong hoidongMaHd) {
        this.hoidongMaHd = hoidongMaHd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (khoaluanPK != null ? khoaluanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoaluan)) {
            return false;
        }
        Khoaluan other = (Khoaluan) object;
        if ((this.khoaluanPK == null && other.khoaluanPK != null) || (this.khoaluanPK != null && !this.khoaluanPK.equals(other.khoaluanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Khoaluan[ khoaluanPK=" + khoaluanPK + " ]";
    }
    
}
