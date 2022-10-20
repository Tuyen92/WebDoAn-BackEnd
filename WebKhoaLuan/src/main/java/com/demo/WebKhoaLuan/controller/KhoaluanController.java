/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;

import com.demo.WebKhoaLuan.model.Khoaluan;
import com.demo.WebKhoaLuan.repository.KhoaluanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KhoaluanController {
    @Autowired
    private KhoaluanRepository khoaLuanRepository;
    
    @GetMapping("/giaovu/dsKhoaLuan")
    public List<Khoaluan> dsKhoaLuan(){
        return khoaLuanRepository.findAll();
    }
    
    @GetMapping("/giaovu/dsKhoaLuan/{maKl}")
    public Khoaluan layKhoaLuan(@PathVariable(value = "maKl") int maKl){
        return khoaLuanRepository.layKhoaLuan(maKl);
    }
    
    @GetMapping("/giangvien/dsKLHuongDan/{maGv}")
    public List<Khoaluan> dsKLHD(@PathVariable(value = "maGv") String maGv){
        return khoaLuanRepository.layKLGV(maGv);
    }
    
    @GetMapping("/giangvien/dsKhoaLuan/{maKl}")
    public Khoaluan dsKLGV(@PathVariable(value = "maKl") int maKl){
        return khoaLuanRepository.layKhoaLuan(maKl);
    }
    
    @DeleteMapping("/giaovu/xoaKhoaLuan/{maKl}")
    public String xoaKhoaLuan(@PathVariable(value = "maKl") int maKl){
        Khoaluan kl = khoaLuanRepository.layKhoaLuan(maKl);
        try {
            khoaLuanRepository.deleteById(kl.getKhoaluanPK());
        } catch (Exception e) {
            return "Xóa khóa luận không thành công";
        }
       return "Xóa khóa luận thành công";
    }
    
    @PostMapping("/sinhvien/nopKhoaLuan/{maKl}")
    public String nopKhoaLuan(@PathVariable(value = "maKl") int maKl){
        Khoaluan kl = khoaLuanRepository.layKhoaLuan(maKl);
        try {
            khoaLuanRepository.save(kl);
        } catch (Exception e) {
            return "Nộp khóa luận không thành công";
        }
        return "Đã nộp khóa luận thành công";
    }
}
