/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Khoaluan;
import com.demo.WebKhoaLuan.model.KhoaluanPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public interface KhoaluanRepository extends JpaRepository<Khoaluan, KhoaluanPK>{
    
    @Query("SELECT k FROM Khoaluan k WHERE k.maGvhd = :#{#maGv} OR k.maGvpb = :#{#maGv}")
    List<Khoaluan> layKLGV(String maGv);
    
    @Query("SELECT k FROM Khoaluan k WHERE k.khoaluanPK.maKl = :#{#maKl}")
    Khoaluan layKhoaLuan(int maKl);
}
