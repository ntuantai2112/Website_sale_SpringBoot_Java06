package com.fpoly.assigment_java06.service_impl;

import com.fpoly.assigment_java06.entity.Product;
import com.fpoly.assigment_java06.repository.ProductRepository;
import com.fpoly.assigment_java06.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByCategoryId(String idCategory) {
        return null;
    }

    @Override
    public Product findById(Integer idProduct) {
        return repository.findById(idProduct).get();
    }

    @Override
    public Page<Product> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Page<Product> findByCategoryId(String cid, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repository.findByCategory_Id(cid,pageable);
    }
}
