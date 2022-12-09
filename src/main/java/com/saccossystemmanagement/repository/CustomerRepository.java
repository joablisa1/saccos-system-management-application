package com.saccossystemmanagement.repository;

import com.saccossystemmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.java2d.loops.CustomComponent;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByIdnumber(Long idnumber);

    Customer findCustomerByEmail(String email);
}
