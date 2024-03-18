package com.springapps.jpaexamples.orderapp;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class OrderSErvice {
    private OrderRepository orderRepository;
@Autowired
    public OrderSErvice(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order findById(Long id)  {
    return orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found"));
    }
    public List<Order> findAll(){
    return orderRepository.findAll();
    }
    public List<Order> findOrdersByLocalDateBetween(LocalDate start,LocalDate end){
    return orderRepository.findAllByOrderDateBetweenOrderByProductType(start,end).orElseThrow(()-> new ResourceNotFoundException("no order between dates found"));
    }
    public Order addOrder(Order order){
    return orderRepository.save(order);
    }
@Transactional
    public Order updateOrder(Order order,Long id)  {
    Order orderToBeUpdated = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("order not found"));
//    order.setOrderId(id);
//   return  orderRepository.save(order);
    orderToBeUpdated.setOrderStatus(order.getOrderStatus());
    orderToBeUpdated.setOrderDate(order.getOrderDate());
    orderToBeUpdated.setProductType(order.getProductType());
    return orderRepository.save(orderToBeUpdated);

    }
    public void deleteOrder(Long id){
    orderRepository.deleteById(id);
    }
}
