package com.fpoly.assigment_java06.service;

import com.fpoly.assigment_java06.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface AccountService{

    Account findById(String username);

    public Account findByUsernameAndPassword(String username, String password) ;

}
