package com.springapps.jpaexamples.orderapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderSErvice orderSErvice;

    @Autowired
    public OrderController(OrderSErvice orderSErvice) {
        this.orderSErvice = orderSErvice;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findALl() {
        List<Order> orders = orderSErvice.findAll();
        return ResponseEntity.ok(orders);
    }

    //@GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//    try {
//        Order order = orderSErvice.findById(id);
//        return ResponseEntity.ok(order);
//
//    } catch (Exception e) {
//        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
//    }
//}
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Order order = orderSErvice.findById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/between")
    public ResponseEntity<List<Order>> findByLOcalDateBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
//        LocalDate startDate = LocalDate.parse(start, formatter);
//        LocalDate endDate = LocalDate.parse(end, formatter);
        List<Order> orders = orderSErvice.findOrdersByLocalDateBetween(start, end);
        return ResponseEntity.ok(orders);

    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order savedOrder = orderSErvice.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        Order updatedOrder = orderSErvice.updateOrder(order, id);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderSErvice.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

