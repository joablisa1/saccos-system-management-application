package com.saccossystemmanagement.service;

import com.saccossystemmanagement.model.Address;
import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.model.Payment;
import com.saccossystemmanagement.payload.CustomerDto;
import com.saccossystemmanagement.payload.CustomerRequest;
import com.saccossystemmanagement.repository.CategoryRepository;
import com.saccossystemmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    public static Customer saveCustomer(CustomerDto customerDto,Category category) {
        Customer customer=new Customer();
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setIdnumber(customerDto.getIdnumber());
        customer.setPassword(customerDto.getPassword());
        Address address=customerDto.getAddress();
        customer.setAddress(address);
        customer.setCategory(category);
        Payment payments=customerDto.getPayment();
        customer.setPayment(payments);
        return customer;
    }
    public void addCustomer(CustomerDto customerDto, Category category){
        Customer customer=saveCustomer(customerDto,category);
        customerRepository.save(customer);
    }

    public Customer findCustomeById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }
    public Customer findCustomerByIdNumber(Long idnumber) {
        return customerRepository.findCustomerByIdnumber(idnumber);
    }

    public void updateCustomer(Long customerID, CustomerDto customerDto, Category category) {
        Customer customer=saveCustomer(customerDto,category);
        customer.setId(customerID);
        customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public boolean isCustomerPresent(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email);
        if (customer != null)
            return true;
        return false;
    }

}
