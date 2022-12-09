package com.saccossystemmanagement.payload;

import com.saccossystemmanagement.model.Address;
import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.model.Payment;

public class CustomerRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private Long idnumber;
    private String email;
    private String phone;
    private String password;
    private Address address;
    private Payment payment;

     private Category category;
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(Long idnumber) {
        this.idnumber = idnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Long getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(Long categoryId) {
        categoryId = categoryId;
    }

    public Customer toCustomer(){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setIdnumber(idnumber);
        customer.setPassword(password);
        Address address=new Address();
        customer.setAddress(address);
        Category category=new Category();
        category.setId(categoryId);
        customer.getCategory().setName(category.getName());// added
        customer.setCategory(category);
        Payment payments=new Payment();
        customer.setPayment(payments);
        return customer;
    }

//    public  Customer saveCustomer(){
//        Customer customer=new Customer();
//        customer.setFirstname(customerRequest.getFirstname());
//        customer.setLastname(customerRequest.getLastname());
//        customer.setPhone(customerRequest.getPhone());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setIdnumber(customerRequest.getIdnumber());
//        customer.setPassword(customerRequest.getPassword());
//        customer.setCategory(customerRequest.getCategory());
//        Address address=customerRequest.getAddress();
//        customer.setAddress(address);
//        Payment payment=customerRequest.getPayment();
//        customer.setPayment(payment);
//        return customer;
//    }

//    public  static  CustomerRequest customerRequest(Customer customer){
//        CustomerRequest request=new CustomerRequest();
//        request.setId(customer.getId());
//        request.setFirstname(customer.getFirstname());
//        request.setLastname(customer.getLastname());
//        request.setPhone(customer.getPhone());
//        request.setEmail(customer.getEmail());
//        request.setIdnumber(customer.getIdnumber());
//        request.setPassword(customer.getPassword());
//        Address address=new Address();
//        request.setAddress(address);
//        request.setCategoryId(customer.getCategory().getId());
//        Payment payments=new Payment();
//        request.setPayment(payments);
//        return request;
//
//    }


}
