package com.saccossystemmanagement.payload;

import com.saccossystemmanagement.model.Address;
import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.model.Payment;

public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Long idnumber;
    private String email;
    private String phone;
    private String password;
    private Address address;
    private Payment payment;
    private Long categoryId;

    public CustomerDto() {
    }

    public  CustomerDto(Customer customer){
        this.setId(customer.getId());
        this.setFirstname(customer.getFirstname());
        this.setLastname(customer.getLastname());
        this.setEmail(customer.getEmail());
        this.setIdnumber(customer.getIdnumber());
        this.setPhone(customer.getPhone());
        this.setPassword(customer.getPassword());
        this.setAddress(customer.getAddress());
        this.setCategoryId(customer.getCategory().getId());
        this.setPayment(customer.getPayment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
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
        this.categoryId = categoryId;
    }
}
