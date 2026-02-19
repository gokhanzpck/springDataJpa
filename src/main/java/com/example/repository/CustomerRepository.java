package com.example.repository;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
