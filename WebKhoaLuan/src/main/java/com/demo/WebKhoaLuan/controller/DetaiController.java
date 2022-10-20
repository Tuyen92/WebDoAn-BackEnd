/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;

import com.demo.WebKhoaLuan.model.Detai;
import com.demo.WebKhoaLuan.repository.DetaiRepository;
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
public class DetaiController {
    @Autowired
    private DetaiRepository deTaiRepository;
    
    @GetMapping("/dsDeTai")
    public List<Detai> dsDeTai(){
        return deTaiRepository.findAll();
    }
    
    @GetMapping("/dsDeTai/khoa/{maKhoa}")
    public List<Detai> dsDeTaiKhoa(@PathVariable(value = "maKhoa") String maKhoa){
        return deTaiRepository.dsDeTaiKhoa(maKhoa);
    }
    
    @GetMapping("/dsDeTai/{maDt}")
    public Detai layDeTai(@PathVariable(value = "maDt") int maDt){
        return deTaiRepository.layDeTai(maDt);
    }
    
    @DeleteMapping("/giaovu/xoaDeTai/{maDt}")
    public String xoaDeTai(@PathVariable(value = "maDt") int maDt){
        try {
            deTaiRepository.deleteById(maDt);
        } catch (Exception e) {
            return "Xóa đề tài không thành công";
        }
        return "Xóa đề tài thành công";
    }
    
    @PostMapping("/giaovu/themDeTai")
    public String themDeTai(@RequestBody Detai detai){
        try {
            deTaiRepository.save(detai);
        } catch (Exception e) {
            return "Thêm đề tài không thành công";
        }
        return "Thêm đề tài thành công";
    }
}
