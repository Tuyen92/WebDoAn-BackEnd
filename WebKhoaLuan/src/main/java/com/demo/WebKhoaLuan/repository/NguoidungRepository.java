/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demo.WebKhoaLuan.repository;

import com.demo.WebKhoaLuan.model.Nguoidung;
import com.demo.WebKhoaLuan.model.NguoidungPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public interface NguoidungRepository extends JpaRepository<Nguoidung, NguoidungPK>{
    
    
    @Query("SELECT n FROM Nguoidung n WHERE n.nguoidungPK.maNd = :#{#maNd}")
    Nguoidung layND(String maNd);

    @Query("SELECT n FROM Nguoidung n WHERE n.nguoidungPK.chucvuMaCv = :#{#maCv}")
    List<Nguoidung> layLoaiND(String maCv);
    
    @Modifying
    @Query("DELETE FROM Nguoidung n WHERE n.nguoidungPK.maNd = :#{#maNd}")
    void deleteByMaNd(@Param("maNd") String maNd);

    @Query("SELECT n FROM Nguoidung n WHERE n.hoatDong = :#{#hoatDong}")
    List<Nguoidung> layDSHoatDong(short hoatDong);
}
