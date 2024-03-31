package com.fpoly.assigment_java06.controller;

import com.fpoly.assigment_java06.entity.Account;
import com.fpoly.assigment_java06.service.AccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/security")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    HttpSession session;

    public  static  Account account;

    //    @GetMapping("")
    @GetMapping("/login/form")
    public String loginForm(Model model){
        model.addAttribute("message","Vui lòng đăng nhập!");
        return "security/login";
    }

    @PostMapping("/login/form")
    public String loginFormSuccess(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Kiểm tra username và password từ cơ sở dữ liệu
         account = accountService.findByUsernameAndPassword(username, password);
        if (account != null) {
            model.addAttribute("account",account);
            // Lưu thông tin tài khoản vào session
            session.setAttribute("account", account);
            System.out.println(account.getFullname());
            return "redirect:/order/checkout";
        } else {
            // Nếu không tìm thấy tài khoản, hiển thị thông báo lỗi
            model.addAttribute("message", "Invalid username or password");
            return "security/login";
        }
    }

    @GetMapping("/logoff")
    public String logout(Model model){
        model.addAttribute("message","Bạn đã đăng xuất!");
        return "layout/main";
    }

}
