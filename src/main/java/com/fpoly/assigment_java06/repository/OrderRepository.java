package com.fpoly.assigment_java06.repository;

import com.fpoly.assigment_java06.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

//   @Query(" SELECT o FROM Order o WHERE O.account.username =?1")
    List<Order> findByAccount_Username(String username);
}
