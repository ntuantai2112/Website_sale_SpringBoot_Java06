package com.fpoly.assigment_java06.service_impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.assigment_java06.entity.Order;
import com.fpoly.assigment_java06.entity.OrderDetail;
import com.fpoly.assigment_java06.repository.OrderDetailRepository;
import com.fpoly.assigment_java06.repository.OrderRepository;
import com.fpoly.assigment_java06.service.OrderDetailService;
import com.fpoly.assigment_java06.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode orderData) {

        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };


        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek( d -> d.setOrder(order)).collect(Collectors.toList());

        orderRepository.save(order);
        orderDetailRepository.saveAll(details);

        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderRepository.findByAccount_Username(username);
    }
}
