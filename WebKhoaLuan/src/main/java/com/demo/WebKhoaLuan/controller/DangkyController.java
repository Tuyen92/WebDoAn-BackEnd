/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;

import com.demo.WebKhoaLuan.model.Dangkykhoaluan;
import com.demo.WebKhoaLuan.model.Khoaluan;
import com.demo.WebKhoaLuan.repository.DangkyRepository;
import com.demo.WebKhoaLuan.repository.KhoaluanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DangkyController {
    @Autowired
    private DangkyRepository dangkyRepository;
    @Autowired
    private KhoaluanRepository khoaluanRepository;
    
    @GetMapping("/giaovu/dsDangKy")
    public List<Dangkykhoaluan> dsDangKy(){
        return dangkyRepository.findAll();
    }
    
    @GetMapping("/giaovu/dsDKDaXet")
    public List<Dangkykhoaluan> dsDKXetDuyet(){
        return dangkyRepository.dsDKXetDuyet(Short.parseShort("1"));
    }
    
    @GetMapping("/giaovu/dsDKChuaDaXet")
    public List<Dangkykhoaluan> dsDKChuaXetDuyet(){
        return dangkyRepository.dsDKXetDuyet(Short.parseShort("0"));
    }
    
    @GetMapping("/giaovu/dsDangKy/{maSv}")
    public Dangkykhoaluan layDangKy(@PathVariable(value = "maSv") String maSv){
        return dangkyRepository.layDKSV(maSv);
    }
    
    @DeleteMapping("/giaovu/xoaDangKy/{maDk}")
    public String xoaDangKy(@PathVariable(value = "maDk") int maDk){
        Dangkykhoaluan dk = dangkyRepository.layDK(maDk);
        if (dk.getXetDuyet() == 1)
            return "Không cho xóa";
        else
            dangkyRepository.deleteById(dk.getDangkykhoaluanPK());
        return "Xóa thành công";
    }
    
    @PostMapping("/sinhvien/dangKyKL")
    public String themDK(@RequestBody Dangkykhoaluan dangkykhoaluan){
        dangkykhoaluan.setXetDuyet(Short.parseShort("0"));
        try {
            dangkyRepository.save(dangkykhoaluan);
        } catch (Exception e) {
            return "Đăng ký không thành công";
        }
        return "Đăng ký thành công";
    }
    
    @PostMapping("/giaovu/xetDuyet/{maDk}")
    public String xetDuyetDK(@PathVariable(value = "maDk") int maDk, @RequestBody Khoaluan khoaluan){
        Dangkykhoaluan dk = dangkyRepository.layDK(maDk);
        dk.setXetDuyet(Short.parseShort("1"));
        khoaluan.setDangkykhoaluan(dk);
        try {
            dangkyRepository.save(dk);
            khoaluanRepository.save(khoaluan);
        } catch (Exception e) {
            return "Xét duyệt khóa luận không thành công";
        }
        return "Xét duyệt khóa luận thành công";
    }
}
