/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Dangkykhoaluan;
import com.demo.WebKhoaLuan.model.DangkykhoaluanPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public interface DangkyRepository extends JpaRepository<Dangkykhoaluan, DangkykhoaluanPK>{
    
    @Query("SELECT dk FROM Dangkykhoaluan dk WHERE dk.xetDuyet = :#{#xetDuyet}")
    List<Dangkykhoaluan> dsDKXetDuyet(short xetDuyet);
    
    @Query("SELECT dk FROM Dangkykhoaluan dk WHERE dk.maSv = :#{#maSv}")
    Dangkykhoaluan layDKSV(String maSv);
    
    @Query("SELECT dk FROM Dangkykhoaluan dk WHERE dk.dangkykhoaluanPK.maDk = :#{#maDk}")
    Dangkykhoaluan layDK(int maDk);
    
    @Modifying
    @Query("DELETE FROM Dangkykhoaluan dk WHERE dk.dangkykhoaluanPK.maDk = :#{#maDk}")
    void xoaDangKy(@Param("maDk") int maDk);
}
