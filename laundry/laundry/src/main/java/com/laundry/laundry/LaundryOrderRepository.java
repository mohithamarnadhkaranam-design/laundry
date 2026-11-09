package com.laundry.laundry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundryOrderRepository
        extends JpaRepository<LaundryOrder, Long> {

    long countByStatus(String status);
}