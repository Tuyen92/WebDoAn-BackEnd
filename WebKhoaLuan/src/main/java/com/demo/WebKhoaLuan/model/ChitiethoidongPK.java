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
public class ChitiethoidongPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_gv")
    private String maGv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ma_hd")
    private int maHd;

    public ChitiethoidongPK() {
    }

    public ChitiethoidongPK(String maGv, int maHd) {
        this.maGv = maGv;
        this.maHd = maHd;
    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGv != null ? maGv.hashCode() : 0);
        hash += (int) maHd;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitiethoidongPK)) {
            return false;
        }
        ChitiethoidongPK other = (ChitiethoidongPK) object;
        if ((this.maGv == null && other.maGv != null) || (this.maGv != null && !this.maGv.equals(other.maGv))) {
            return false;
        }
        if (this.maHd != other.maHd) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.ChitiethoidongPK[ maGv=" + maGv + ", maHd=" + maHd + " ]";
    }
    
}
