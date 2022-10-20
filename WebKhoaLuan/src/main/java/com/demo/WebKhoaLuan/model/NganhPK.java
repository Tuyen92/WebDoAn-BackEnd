/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ADMIN
 */
@Embeddable
public class NganhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_nganh")
    private String maNganh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "khoa_ma_khoa")
    private String khoaMaKhoa;

    public NganhPK() {
    }

    public NganhPK(String maNganh, String khoaMaKhoa) {
        this.maNganh = maNganh;
        this.khoaMaKhoa = khoaMaKhoa;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getKhoaMaKhoa() {
        return khoaMaKhoa;
    }

    public void setKhoaMaKhoa(String khoaMaKhoa) {
        this.khoaMaKhoa = khoaMaKhoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNganh != null ? maNganh.hashCode() : 0);
        hash += (khoaMaKhoa != null ? khoaMaKhoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NganhPK)) {
            return false;
        }
        NganhPK other = (NganhPK) object;
        if ((this.maNganh == null && other.maNganh != null) || (this.maNganh != null && !this.maNganh.equals(other.maNganh))) {
            return false;
        }
        if ((this.khoaMaKhoa == null && other.khoaMaKhoa != null) || (this.khoaMaKhoa != null && !this.khoaMaKhoa.equals(other.khoaMaKhoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.NganhPK[ maNganh=" + maNganh + ", khoaMaKhoa=" + khoaMaKhoa + " ]";
    }
    
}
