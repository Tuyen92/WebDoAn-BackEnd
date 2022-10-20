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
public class NguoidungPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_nd")
    private String maNd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "chucvu_ma_cv")
    private String chucvuMaCv;

    public NguoidungPK() {
    }

    public NguoidungPK(String maNd, String chucvuMaCv) {
        this.maNd = maNd;
        this.chucvuMaCv = chucvuMaCv;
    }

    public String getMaNd() {
        return maNd;
    }

    public void setMaNd(String maNd) {
        this.maNd = maNd;
    }

    public String getChucvuMaCv() {
        return chucvuMaCv;
    }

    public void setChucvuMaCv(String chucvuMaCv) {
        this.chucvuMaCv = chucvuMaCv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNd != null ? maNd.hashCode() : 0);
        hash += (chucvuMaCv != null ? chucvuMaCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoidungPK)) {
            return false;
        }
        NguoidungPK other = (NguoidungPK) object;
        if ((this.maNd == null && other.maNd != null) || (this.maNd != null && !this.maNd.equals(other.maNd))) {
            return false;
        }
        if ((this.chucvuMaCv == null && other.chucvuMaCv != null) || (this.chucvuMaCv != null && !this.chucvuMaCv.equals(other.chucvuMaCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.NguoidungPK[ maNd=" + maNd + ", chucvuMaCv=" + chucvuMaCv + " ]";
    }
    
}
