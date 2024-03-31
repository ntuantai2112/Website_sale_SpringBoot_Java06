//package com.fpoly.assigment_java06.controller;
//
//
//import org.springframework.context.annotation.Bean;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//
//public class SecurityController {
//
//    //    @GetMapping("")
//    @RequestMapping("/security/login/form")
//    public String loginForm(Model model){
//        model.addAttribute("message","Vui lòng đăng nhập!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/login/form")
//    public String loginFormSuccess(Model model){
//        model.addAttribute("message","Đăng nhặp thành công!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/login/error")
//    public String loginFormError(Model model){
//        model.addAttribute("message","Sai thông tin đăng nhập!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/unauthoried")
//    public String unauthoried(Model model){
//        model.addAttribute("message","Bạn không có quyền truy cập vào chức năng này!");
//        return "security/login";
//    }
//
//    @RequestMapping("/security/logoff/success")
//    public String logout(Model model){
//        model.addAttribute("message","Bạn đã đăng xuất!");
//        return "layout/main";
//    }
//
//
//
//}
