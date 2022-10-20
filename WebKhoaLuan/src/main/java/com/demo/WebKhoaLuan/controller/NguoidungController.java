/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.WebKhoaLuan.controller;
//
//import com.demo.WebKhoaLuan.config.JWTToken;
//import com.demo.WebKhoaLuan.login.LoginRequest;
//import com.demo.WebKhoaLuan.login.LoginResponse;
import com.demo.WebKhoaLuan.model.Nguoidung;
import com.demo.WebKhoaLuan.repository.NguoidungRepository;
import java.util.List;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NguoidungController {
    @Autowired
    private NguoidungRepository nguoidungRepository;
    @Autowired
    private SinhvienRepository sinhVienRepository;
    @Autowired
    private GiangvienRepository giangVienRepository;
    @Autowired
    private GiaovuRepository giaoVuRepository;
    @Autowired
    private QuantriRepository quanTriRepository;
    
//    @Autowired
//    private AuthenticationManager authenticationManager;
    
//    @Autowired
//    private JWTToken tokenProvider;
//    
//    @PostMapping("/login")
//    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        // Xác thực từ username và password.
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        // Nếu không xảy ra exception tức là thông tin hợp lệ
//        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((Nguoidung) authentication.getPrincipal());
//        return new LoginResponse(jwt);
//    }

    
    //QUẢN TRỊ
    @PostMapping("/quantri/themND")
    public Nguoidung themNguoidung(@RequestBody Nguoidung nguoidung){
        nguoidung.setHoatDong(Short.parseShort("1"));
        switch (nguoidung.getNguoidungPK().getChucvuMaCv()) {
            case "ROLE_QT":
                Quantri qt = new Quantri();
                qt.setNguoidung(nguoidung);
                qt.setMaQt(nguoidung.getNguoidungPK().getMaNd());
                quanTriRepository.save(qt);
                break;
            case "ROLE_GVU":
                Giaovu gvu = new Giaovu();
                gvu.setNguoidung(nguoidung);
                gvu.setMaGvu(nguoidung.getNguoidungPK().getMaNd());
                giaoVuRepository.save(gvu);
                break;
            case "ROLE_GV":
                Giangvien gv = new Giangvien();
                gv.setNguoidung(nguoidung);
                gv.setMaGv(nguoidung.getNguoidungPK().getMaNd());
                giangVienRepository.save(gv);
                break;
            case "ROLE_SV":
                Sinhvien sv = new Sinhvien();
                sv.setNguoidung(nguoidung);
                sv.setMaSv(nguoidung.getNguoidungPK().getMaNd());
                sinhVienRepository.save(sv);
                break;
            default:
                throw new AssertionError();
        } 
        return nguoidungRepository.save(nguoidung);
    }
    
    @GetMapping("/quantri/qlTaiKhoan")
    public List<Nguoidung> layDSNguoidung(){
        return nguoidungRepository.findAll();
    }
    
    @GetMapping("/quantri/qlTaiKhoan/{maNd}")
    public Nguoidung timNguoidung(@PathVariable(value = "maNd") String maNd){
        return nguoidungRepository.layND(maNd);
    }
    
    @GetMapping("/nguoidung/{maNd}")
    public Nguoidung layNguoidung(@PathVariable(value = "maNd") String maNd){
        return nguoidungRepository.layND(maNd);
    }
    
    @GetMapping("/quantri/qlTaiKhoan/loai/{maCv}")
    public List<Nguoidung> layDSLoaiND(@PathVariable(value = "maCv") String maCv){
        return nguoidungRepository.layLoaiND(maCv);
    }
    
    @DeleteMapping("/quantri/xoaND/{maNd}")
    public String xoaNguoidung(@PathVariable(value = "maNd") String maNd){
        Nguoidung nd = nguoidungRepository.layND(maNd);
        switch (nd.getNguoidungPK().getChucvuMaCv()) {
            case "ROLE_QT":
                quanTriRepository.deleteById(maNd);
                break;
            case "ROLE_GVU":
                giaoVuRepository.deleteById(maNd);
                break;
            case "ROLE_GV":
                giangVienRepository.deleteById(maNd);
                break;
            case "ROLE_SV":
                sinhVienRepository.deleteById(maNd);
                break;
        }
        try {
            nguoidungRepository.deleteByMaNd(maNd);
        } catch (Exception e) {
            return "Xóa người dùng không thành công";
        }
        return "Đã xóa ngời dùng thành công";
    }
    
    @PostMapping("/quantri/capnhatND/{maNd}")
    public String capNhatND(@PathVariable (value = "maNd") String maNd, @RequestBody Nguoidung nguoidung) {
        Nguoidung nd = nguoidungRepository.layND(maNd);
        if (!nguoidung.getHo().isEmpty())
            nd.setHo(nguoidung.getHo());
        if (!nguoidung.getTen().isEmpty())
            nd.setTen(nguoidung.getTen());
        if (nguoidung.getNgaySinh() != null)
            nd.setNgaySinh(nguoidung.getNgaySinh());
        if (!nguoidung.getDiaChi().isEmpty())
            nd.setDiaChi(nguoidung.getDiaChi());
        if (!nguoidung.getEmail().isEmpty())
            nd.setEmail(nguoidung.getEmail());
        if (!nguoidung.getGioiTinh().isEmpty())
            nd.setGioiTinh(nguoidung.getGioiTinh());
        if (!nguoidung.getSdt().isEmpty())
            nd.setSdt(nguoidung.getSdt());
        try {
            nguoidungRepository.save(nd);
        } catch (Exception e) {
            return "Cập nhật người dùng không thành công";
        }
        return "Cập nhật người dùng thành công";
    }
    
    @PostMapping("/capnhatND/{maNd}")
    public String capNhatNDCaNhan(@PathVariable(value = "maNd") String maNd, @RequestBody Nguoidung nguoidung){
        Nguoidung nd = nguoidungRepository.layND(maNd);
        if (nguoidung.getNgaySinh() != null)
            nd.setNgaySinh(nguoidung.getNgaySinh());
        if (!nguoidung.getDiaChi().isEmpty())
            nd.setDiaChi(nguoidung.getDiaChi());
        if (!nguoidung.getEmail().isEmpty())
            nd.setEmail(nguoidung.getEmail());
        if (!nguoidung.getSdt().isEmpty())
            nd.setSdt(nguoidung.getSdt());
        try {
            nguoidungRepository.save(nd);
        } catch (Exception e) {
           return "Cập nhật người dùng không thành công"; 
        }
        return "Cập nhật người dùng thành công";
    }
    
    @PostMapping("/quantri/tinhTrangTK/{maNd}")
    public void capNhatTinhTrang(@PathVariable(value = "maNd") String maNd){
        Nguoidung nd = nguoidungRepository.layND(maNd);
        if (nd.getHoatDong() == 1)
            nd.setHoatDong(Short.parseShort("0"));
        else
            nd.setHoatDong(Short.parseShort("1"));
        nguoidungRepository.save(nd);
    }
    
    @GetMapping("/quantri/dsSVKhoa/{maKhoa}")
    public List<Sinhvien> dsSinhVienKhoa(@PathVariable(value = "maKhoa") String maKhoa){
        return sinhVienRepository.laySVKhoa(maKhoa);
    }
    
    @GetMapping("/quantri/dsSVNganh/{maNganh}")
    public List<Sinhvien> dsSinhVienNganh(@PathVariable(value = "maNganh") String maNganh){
        return sinhVienRepository.laySVNganh(maNganh);
    }
    
    @GetMapping("/quantri/dsTaiKhoanVHH")
    public List<Nguoidung> dsTaiKhoanVHH(){
        return nguoidungRepository.layDSHoatDong(Short.parseShort("0"));
    }
    
    @GetMapping("/quantri/dsTaiKhoanHLH")
    public List<Nguoidung> dsTaiKhoanHLH(){
        return nguoidungRepository.layDSHoatDong(Short.parseShort("1"));
    }
}
