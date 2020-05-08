package com.quantitymeasurement.repository;

import com.quantitymeasurement.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, String> {
}

