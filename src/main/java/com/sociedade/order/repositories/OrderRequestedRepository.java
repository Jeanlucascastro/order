package com.sociedade.order.repositories;


import com.sociedade.order.domain.orders.OrderRequested;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestedRepository extends JpaRepository<OrderRequested, Long> {

}
