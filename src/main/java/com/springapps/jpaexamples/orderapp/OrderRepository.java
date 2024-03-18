package com.springapps.jpaexamples.orderapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByProductType(String productType);

    Optional<List<Order>> findAllByOrderDateBetweenOrderByProductType(LocalDate start, LocalDate end);


    List<Order> findAllByOrderStatusIn(List<Order> orderStatusList);
}
