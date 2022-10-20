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

/**
 *
 * @author ADMIN
 */
@Embeddable
public class DangkykhoaluanPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_dk")
    private int maDk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "detai_ma_dt")
    private int detaiMaDt;

    public DangkykhoaluanPK() {
    }

    public DangkykhoaluanPK(int maDk, int detaiMaDt) {
        this.maDk = maDk;
        this.detaiMaDt = detaiMaDt;
    }

    public int getMaDk() {
        return maDk;
    }

    public void setMaDk(int maDk) {
        this.maDk = maDk;
    }

    public int getDetaiMaDt() {
        return detaiMaDt;
    }

    public void setDetaiMaDt(int detaiMaDt) {
        this.detaiMaDt = detaiMaDt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maDk;
        hash += (int) detaiMaDt;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DangkykhoaluanPK)) {
            return false;
        }
        DangkykhoaluanPK other = (DangkykhoaluanPK) object;
        if (this.maDk != other.maDk) {
            return false;
        }
        if (this.detaiMaDt != other.detaiMaDt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.DangkykhoaluanPK[ maDk=" + maDk + ", detaiMaDt=" + detaiMaDt + " ]";
    }
    
}
