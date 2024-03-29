package com.fpoly.assigment_java06.service;

import org.springframework.stereotype.Service;
import com.fpoly.assigment_java06.entity.Category;

import java.util.List;


public interface CategoryService {


    List<Category> findAll();
}
