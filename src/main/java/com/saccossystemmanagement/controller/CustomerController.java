package com.saccossystemmanagement.controller;

import com.saccossystemmanagement.model.Address;
import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.model.Payment;
import com.saccossystemmanagement.payload.CustomerDto;
import com.saccossystemmanagement.payload.CustomerRequest;
import com.saccossystemmanagement.service.CategoryService;
import com.saccossystemmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> findAllCustomerListResponseEntity(){
        List<Customer> customers=customerService.customerList();
        customers.stream().map(customer -> new Customer()).collect(Collectors.toList());
        if(customers.size()==0){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Sorry record does not exist");
        }
       return  new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping("/customer/save")
    public ResponseEntity<Customer>saveCustomerResponseEntity(@RequestBody CustomerDto customerDto){
//         Customer customer=new Customer();
//         customer.setFirstname(customerRequest.getFirstname());
//         customer.setLastname(customerRequest.getLastname());
//         customer.setPhone(customerRequest.getPhone());
//         customer.setIdnumber(customerRequest.getIdnumber());
//         customer.setEmail(customerRequest.getEmail());
//         customer.setPassword(customerRequest.getPassword());
//         Category category=new Category();
//         category.setId(customerRequest.getCategoryId());
//         customer.setCategory(category);
//         Address address=new Address();
//         address.setPostalAddress(customerRequest.getAddress().getPostalAddress());
//         address.setPostalCode(customerRequest.getAddress().getPostalCode());
//         address.setTown(customerRequest.getAddress().getTown());
//         address.setVillage(customerRequest.getAddress().getVillage());
//         customer.setAddress(address);
//         Payment payment=new Payment();
//         payment.setAmount(customerRequest.getPayment().getAmount());
//         customer.setPayment(payment);
//         Customer customer=customerRequest.toCustomer();
         Category category=categoryService.findCategoryById(customerDto.getCategoryId());
         customerService.addCustomer(customerDto,category);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/customer/find/{idnumber}")
    public ResponseEntity<Customer>findCustomerByIdnumberCustomerResponseEntity(@PathVariable("idnumber") Long idnumber){
        return new ResponseEntity<>(customerService.findCustomerByIdNumber(idnumber),HttpStatus.OK);
    }
    @GetMapping("/customer/detect/{id}")
    public ResponseEntity<Customer> findCustomerByIdCustomerResponseEntity(@PathVariable("id")Long id){
        return  new ResponseEntity<>(customerService.findCustomeById(id),HttpStatus.OK);
    }
    @PutMapping("/customer/update/{customerID}")
    public ResponseEntity<Customer> updateCustomerResponseEntity(@PathVariable("customerID") Long customerID, @RequestBody CustomerDto customerDto){
        Category category=categoryService.findCategoryById(customerDto.getCategoryId());
        customerService.updateCustomer(customerID,customerDto,category);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?>deleteCustomerByIdResponseEntity(@PathVariable("id")Long id){
        customerService.deleteCustomerById(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
