//package com.fpoly.assigment_java06.store;
//
//
//import com.fpoly.assigment_java06.entity.Account;
//import com.fpoly.assigment_java06.service.AccountService;
//import com.fpoly.assigment_java06.service_impl.AccountServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    AccountService accountService;
////
////    @Autowired
////    BCryptPasswordEncoder pe;
//
//
//    //    Cung cấp nguồn dữ liệu đăng nhập
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> {
//            try {
//                Account user = accountService.findById(username);
//                BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
//                String password = pe.encode(user.getPassword());
//                String[] roles = user.getAuthorities().stream()
//                        .map(er -> er.getRole().getId())
//                        .collect(Collectors.toList()).toArray(new String[0]);
//                return User.withUsername(username).password(password).roles(roles).build();
//
//            } catch (UsernameNotFoundException  e) {
//                throw new UsernameNotFoundException(username + "not found");
//            }
//        });
//    }
//
//    // Phân quyền sử dụng
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                // Khi Order phải đăng nhập thì mới order được
//                .antMatchers("/order/**").authenticated()
//                // Chỉ có nhân viên và admin mới vào được đường dẫn Admin
//                .antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
//                // Chỉ có Admin mới vào được đường dẫn rest  authorities
//                .antMatchers("/rest/authorities").hasRole("DIRE")
//                // Các trường hợp khác không phải đăng nhập
//                .anyRequest().permitAll();
//
//
//        // Cấu hình để hiển thị trang login và xử lí login
//        http.formLogin()
//                .loginPage("/security/login/form")
//                .loginProcessingUrl("/security/login")
//                .defaultSuccessUrl("/security/login/success", false)
//                .failureUrl("/security/login/error");
//
//        // Ghi nhớ tài khoản Username và Password
//        http.rememberMe()
//                .tokenValiditySeconds(86400);
//
//
//        // Bắt lỗi ngoại lệ về phân quyền và hiển thị thông báo, không cho vào những chức năng mà không có quyền sử dụng
//        http.exceptionHandling()
//                .accessDeniedPage("/security/unauthoried");
//
//        //Cấu hình để Log out khỏi ứng dụng
//        http.logout()
//                .logoutUrl("/security/logout")
//                .logoutSuccessUrl("/security/logoff/success");
//    }
//
//
//    //Cơ chế mã hóa mật khẩu
////    @Bean
////    public BCryptPasswordEncoder getPasswordEncoder(){
////        return  new BCryptPasswordEncoder();
////    }
//
//    // Cho phép truy xuất REST API từ bên ngoài (domain khác)
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
//
//    }
//}
