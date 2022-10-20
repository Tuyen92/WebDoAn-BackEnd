/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Sinhvien;
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
public interface SinhvienRepository extends JpaRepository<Sinhvien, String>{
    @Query("SELECT s FROM Sinhvien s WHERE s.nganh.khoa.maKhoa = :#{#maKhoa}")
    List<Sinhvien> laySVKhoa(String maKhoa);
    
    @Query("SELECT s FROM Sinhvien s WHERE s.nganh.nganhPK.maNganh = :#{#maNganh}")
    List<Sinhvien> laySVNganh(String maNganh);
}
