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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@JsonIgnoreProperties({"diemSet", "chitiethoidongSet"})
@Entity
@Table(name = "giangvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giangvien.findAll", query = "SELECT g FROM Giangvien g"),
    @NamedQuery(name = "Giangvien.findByMaGv", query = "SELECT g FROM Giangvien g WHERE g.maGv = :maGv"),
    @NamedQuery(name = "Giangvien.findByHocVi", query = "SELECT g FROM Giangvien g WHERE g.hocVi = :hocVi"),
    @NamedQuery(name = "Giangvien.findByHocHam", query = "SELECT g FROM Giangvien g WHERE g.hocHam = :hocHam")})
public class Giangvien implements Serializable {

    @Size(max = 250)
    @Column(name = "hoc_vi")
    private String hocVi;
    @Size(max = 100)
    @Column(name = "hoc_ham")
    private String hocHam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvien")
    private Set<Chitiethoidong> chitiethoidongSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_gv")
    private String maGv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvien")
    private Set<Diem> diemSet;
    @JoinColumns({
        @JoinColumn(name = "nguoidung_ma_nd", referencedColumnName = "ma_nd"),
        @JoinColumn(name = "nguoidung_chucvu_ma_cv", referencedColumnName = "chucvu_ma_cv")})
    @ManyToOne(optional = false)
    private Nguoidung nguoidung;

    public Giangvien() {
    }

    public Giangvien(String maGv) {
        this.maGv = maGv;
    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    @XmlTransient
    public Set<Diem> getDiemSet() {
        return diemSet;
    }

    public void setDiemSet(Set<Diem> diemSet) {
        this.diemSet = diemSet;
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

//    public Chitiethoidong getChitiethoidong() {
//        return chitiethoidong;
//    }
//
//    public void setChitiethoidong(Chitiethoidong chitiethoidong) {
//        this.chitiethoidong = chitiethoidong;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGv != null ? maGv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giangvien)) {
            return false;
        }
        Giangvien other = (Giangvien) object;
        if ((this.maGv == null && other.maGv != null) || (this.maGv != null && !this.maGv.equals(other.maGv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.Giangvien[ maGv=" + maGv + " ]";
    }

    @XmlTransient
    public Set<Chitiethoidong> getChitiethoidongSet() {
        return chitiethoidongSet;
    }

    public void setChitiethoidongSet(Set<Chitiethoidong> chitiethoidongSet) {
        this.chitiethoidongSet = chitiethoidongSet;
    }
    
}
