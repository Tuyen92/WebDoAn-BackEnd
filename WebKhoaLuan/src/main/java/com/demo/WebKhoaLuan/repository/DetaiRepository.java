/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Detai;
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
public interface DetaiRepository extends JpaRepository<Detai, Integer>{
    
    @Query("SELECT dt FROM Detai dt WHERE dt.khoaMaKhoa.maKhoa = :#{#maKhoa}")
    List<Detai> dsDeTaiKhoa(String maKhoa);
    
    @Query("SELECT dt FROM Detai dt WHERE dt.maDt = :#{#maDt}")
    Detai layDeTai(int maDt);
}
