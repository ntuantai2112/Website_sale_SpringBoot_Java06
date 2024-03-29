package com.fpoly.assigment_java06.service;

import com.fpoly.assigment_java06.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {


    List<Product> findAll();


    List<Product> findByCategoryId(String idCategory);

    Product findById(Integer idProduct);

    Page<Product> findAll(int pageNo, int pageSize);

    Page<Product> findByCategoryId(String cid, int p, int i);
}
