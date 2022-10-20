/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Diem;
import com.demo.WebKhoaLuan.model.DiemPK;
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
public interface DiemRepository extends JpaRepository<Diem, DiemPK>{
    @Query("SELECT d FROM Diem d WHERE d.diemPK.khoaluanMaKl = :#{#maKl}")
    List<Diem> layDiemKL(int maKl);
    
    @Query("SELECT d FROM Diem d WHERE d.diemPK.khoaluanMaKl = :#{#maKl} AND d.tieuchi.phanTram <= 40")
    List<Diem> layDiemGVKL(int maKl);
    
    @Query("SELECT d FROM Diem d WHERE d.diemPK.khoaluanMaKl = :#{#maKl} AND d.tieuchi.phanTram > 40")
    List<Diem> layDiemHDKL(int maKl);
}
