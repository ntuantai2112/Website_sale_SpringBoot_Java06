package com.fpoly.assigment_java06.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.assigment_java06.entity.Order;
import org.springframework.stereotype.Service;


public interface OrderService {
    Order create(JsonNode orderData);

    Order findById(Long id);
}
