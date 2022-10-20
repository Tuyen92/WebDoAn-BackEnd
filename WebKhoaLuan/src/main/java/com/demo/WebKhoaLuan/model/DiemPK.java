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
public class DiemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ma_tc")
    private String maTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "giangvien_ma_gv")
    private String giangvienMaGv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_ma_kl")
    private int khoaluanMaKl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_dangkykhoaluan_ma_dk")
    private int khoaluanDangkykhoaluanMaDk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khoaluan_dangkykhoaluan_detai_ma_dt")
    private int khoaluanDangkykhoaluanDetaiMaDt;

    public DiemPK() {
    }

    public DiemPK(String maTc, String giangvienMaGv, int khoaluanMaKl, int khoaluanDangkykhoaluanMaDk, int khoaluanDangkykhoaluanDetaiMaDt) {
        this.maTc = maTc;
        this.giangvienMaGv = giangvienMaGv;
        this.khoaluanMaKl = khoaluanMaKl;
        this.khoaluanDangkykhoaluanMaDk = khoaluanDangkykhoaluanMaDk;
        this.khoaluanDangkykhoaluanDetaiMaDt = khoaluanDangkykhoaluanDetaiMaDt;
    }

    public String getMaTc() {
        return maTc;
    }

    public void setMaTc(String maTc) {
        this.maTc = maTc;
    }

    public String getGiangvienMaGv() {
        return giangvienMaGv;
    }

    public void setGiangvienMaGv(String giangvienMaGv) {
        this.giangvienMaGv = giangvienMaGv;
    }

    public int getKhoaluanMaKl() {
        return khoaluanMaKl;
    }

    public void setKhoaluanMaKl(int khoaluanMaKl) {
        this.khoaluanMaKl = khoaluanMaKl;
    }

    public int getKhoaluanDangkykhoaluanMaDk() {
        return khoaluanDangkykhoaluanMaDk;
    }

    public void setKhoaluanDangkykhoaluanMaDk(int khoaluanDangkykhoaluanMaDk) {
        this.khoaluanDangkykhoaluanMaDk = khoaluanDangkykhoaluanMaDk;
    }

    public int getKhoaluanDangkykhoaluanDetaiMaDt() {
        return khoaluanDangkykhoaluanDetaiMaDt;
    }

    public void setKhoaluanDangkykhoaluanDetaiMaDt(int khoaluanDangkykhoaluanDetaiMaDt) {
        this.khoaluanDangkykhoaluanDetaiMaDt = khoaluanDangkykhoaluanDetaiMaDt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTc != null ? maTc.hashCode() : 0);
        hash += (giangvienMaGv != null ? giangvienMaGv.hashCode() : 0);
        hash += (int) khoaluanMaKl;
        hash += (int) khoaluanDangkykhoaluanMaDk;
        hash += (int) khoaluanDangkykhoaluanDetaiMaDt;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiemPK)) {
            return false;
        }
        DiemPK other = (DiemPK) object;
        if ((this.maTc == null && other.maTc != null) || (this.maTc != null && !this.maTc.equals(other.maTc))) {
            return false;
        }
        if ((this.giangvienMaGv == null && other.giangvienMaGv != null) || (this.giangvienMaGv != null && !this.giangvienMaGv.equals(other.giangvienMaGv))) {
            return false;
        }
        if (this.khoaluanMaKl != other.khoaluanMaKl) {
            return false;
        }
        if (this.khoaluanDangkykhoaluanMaDk != other.khoaluanDangkykhoaluanMaDk) {
            return false;
        }
        if (this.khoaluanDangkykhoaluanDetaiMaDt != other.khoaluanDangkykhoaluanDetaiMaDt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.WebKhoaLuan.model.DiemPK[ maTc=" + maTc + ", giangvienMaGv=" + giangvienMaGv + ", khoaluanMaKl=" + khoaluanMaKl + ", khoaluanDangkykhoaluanMaDk=" + khoaluanDangkykhoaluanMaDk + ", khoaluanDangkykhoaluanDetaiMaDt=" + khoaluanDangkykhoaluanDetaiMaDt + " ]";
    }
    
}
