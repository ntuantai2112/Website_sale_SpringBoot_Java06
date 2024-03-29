package com.fpoly.assigment_java06.service_impl;

import com.fpoly.assigment_java06.entity.Category;
import com.fpoly.assigment_java06.repository.CategoryRepository;
import com.fpoly.assigment_java06.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
