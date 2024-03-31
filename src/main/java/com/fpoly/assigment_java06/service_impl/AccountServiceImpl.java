package com.fpoly.assigment_java06.service_impl;

import com.fpoly.assigment_java06.entity.Account;
import com.fpoly.assigment_java06.repository.AccountRepository;
import com.fpoly.assigment_java06.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repository;

    @Override
    public Account findById(String username) {
        return repository.findById(username).get();
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }
}
