/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;

import com.demo.WebKhoaLuan.model.Chitiethoidong;
import com.demo.WebKhoaLuan.model.Hoidong;
import com.demo.WebKhoaLuan.repository.ChitiethoidongRepository;
import com.demo.WebKhoaLuan.repository.HoidongRepository;
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
public class HoidongController {
    @Autowired
    private HoidongRepository hoiDongRepository;
    @Autowired
    private ChitiethoidongRepository chiTietHoiDongRepository;
    
    @GetMapping("/giaovu/dsHoiDong")
    public List<Hoidong> dsHoiDong(){
        return hoiDongRepository.findAll();
    }
    
    @GetMapping("/giaovu/dsHoiDong/{maHd}")
    public Hoidong layHoiDong(@PathVariable(value = "maHd") int maHd){
        return hoiDongRepository.layHD(maHd);
    }
    
    @GetMapping("/giaovu/dsHDHoatDong")
    public List<Hoidong> dsHDHoatDong(){
        return hoiDongRepository.dsHDHoatDong(Short.parseShort("1"));
    }
    
    @GetMapping("/giaovu/dsHDKhongHoatDong")
    public List<Hoidong> dsHDKHoatDong(){
        return hoiDongRepository.dsHDHoatDong(Short.parseShort("0"));
    }
    
    @GetMapping("/giangvien/dsHoiDongGV/{maGv}")
    public List<Hoidong> dsHDGV(@PathVariable(value = "maGv") String maGv){
        return hoiDongRepository.layHDGV(maGv);
    }
    
    @PostMapping("/giaovu/tinhTrangHD/{maHd}")
    public String tinhTrangHD(@PathVariable(value = "maHd") int maHd){
        Hoidong hd = hoiDongRepository.layHD(maHd);
        if (hd.getTinhTranghd() == 1)
            hd.setTinhTranghd(Short.parseShort("0"));
        else
            hd.setTinhTranghd(Short.parseShort("1"));
        try {
            hoiDongRepository.save(hd);
        } catch (Exception e) {
            return "Cập nhật không thành công";
        }
        return "Cập nhật thành công";
        
    }
    
    @PostMapping("/giaovu/themHD")
    public void themHD(@RequestBody Hoidong hoidong){
        Hoidong hd = new Hoidong();
        hd.setMaHd(hoidong.getMaHd());
        hd.setTenHd(hoidong.getTenHd());
        hoiDongRepository.themHD(hoidong.getMaHd(), hoidong.getTenHd(), hoidong.getTinhTranghd(), hoidong.getNgayLap());
//        try {
//            
//        } catch (Exception e) {
//            return "Thêm hội đồng không thành công";
//        }
//        return "Thêm hội đồng thành công";
    }
    
    @PostMapping("/giaovu/phanCong/{maHd}")
    public String phanCong(@PathVariable(value = "maHd") int maHd, @RequestBody Chitiethoidong chitiethoidong){
        Hoidong hd = hoiDongRepository.layHD(maHd);
        chitiethoidong.setHoidong(hd);
        try {
            chiTietHoiDongRepository.save(chitiethoidong);
        } catch (Exception e) {
            return "Phân công giảng viên không thành công";
        }
        return "Phân công giảng viên thành công";
    }
    
    @DeleteMapping("/giaovu/xoaHD/{maHd}")
    public String xoaHD(@PathVariable(value = "maHd") int maHd){
        try {
            hoiDongRepository.deleteById(maHd);
        } catch (Exception e) {
            return "Xóa hội đồng không thành công";
        }
        return "Xóa hội đồng thành công";
    }
}
