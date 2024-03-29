package com.fpoly.assigment_java06.repository;

import com.fpoly.assigment_java06.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAll(Pageable pageable);

//        @Query("SELECT p FROM Product WHERE p.category.id = ?1")
 Page<Product> findByCategory_Id(String categoryId, Pageable pageable);

}
