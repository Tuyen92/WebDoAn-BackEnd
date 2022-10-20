/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;

import com.demo.WebKhoaLuan.model.Diem;
import com.demo.WebKhoaLuan.model.Tongketkhoaluan;
import com.demo.WebKhoaLuan.repository.DiemRepository;
import com.demo.WebKhoaLuan.repository.TongketRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DiemController {
    @Autowired
    private DiemRepository diemRepository;
    @Autowired
    private TongketRepository tongKetRepository;
    
    @PostMapping("/giangvien/chamDiem")
    public void chamDiem(@RequestParam Diem diem){
        diemRepository.save(diem);
    }
    
    @PostMapping("/sinhvien/xemKQ/{maSv}/{maKl}")
    public Tongketkhoaluan xemKetQua(@PathVariable(value = "maSv") String maSv, @PathVariable(value = "maKl") int maKl){
        List<Diem> diemGV = diemRepository.layDiemGVKL(maKl);
        List<Diem> diemHD = diemRepository.layDiemHDKL(maKl);
        double diemTong = 0;
        diemTong = (tinhTBC(diemGV) * 0.4) + (tinhTBC(diemHD) * 0.6);
        String result = xetKetQua(diemTong);
        Tongketkhoaluan tk = new Tongketkhoaluan();
        tk.setMaSv(maSv);
        tk.setDiem(BigDecimal.valueOf(diemTong));
        tk.setKetQua(result);
        return tongKetRepository.save(tk);
    }
    
    public double tinhTBC(List<Diem> diem){
        double diemTBC = 0;
        for (int i = 0; i < diem.size(); i++){
            diemTBC += Double.parseDouble(String.valueOf(diem.get(i).getDiem()));
        }
        diemTBC = diemTBC / Double.parseDouble(String.valueOf(diem.size()));
        return diemTBC;
    }

    public String xetKetQua(double score) {
        if (score <= 10 && score >= 8.5) {
            return "A";
        }
        if (score < 8.5 && score >= 8) {
            return "B+";
        }
        if (score < 8 && score >= 7) {
            return "B";
        }
        if (score < 7 && score >= 6.5) {
            return "C+";
        }
        if (score < 6.5 && score >= 5.5) {
            return "C";
        }
        if (score < 5.5 && score >= 5) {
            return "D+";
        }
        if (score < 5 &&score >= 4) {
            return "D";
        }
        return "F";
    }
}
