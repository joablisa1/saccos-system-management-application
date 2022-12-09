package com.saccossystemmanagement.controller;

import com.saccossystemmanagement.model.Contribution;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.service.ContributionService;
import com.saccossystemmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContributionController {

    @Autowired
    ContributionService  contributionService;

    @Autowired
    CustomerService customerService;
    @GetMapping("/contribution")
    public ResponseEntity<List<Contribution>> findAllContriListResponseEntity(){
        return new ResponseEntity<>(contributionService.findAllContributionList(), HttpStatus.OK);
    }
    @PostMapping("/contribution/save")
    public ResponseEntity<Contribution> saveContributionResponseEntity(@RequestBody Contribution contribution){
        Customer customer=customerService.findCustomerByIdNumber(contribution.getCustomer().getIdnumber());
        return new ResponseEntity<>(contributionService.saveContribution(contribution,customer),HttpStatus.ACCEPTED);
    }
    @PutMapping("/contribution/update")
    public ResponseEntity<Contribution> updateContributionResponseEntity(@RequestBody Contribution contribution){
        Customer customer=customerService.findCustomerByIdNumber(contribution.getCustomer().getIdnumber());
        return  new ResponseEntity<>(contributionService.updateContribution(contribution,customer),HttpStatus.ACCEPTED);
    }
    @GetMapping("/contribution/find/{id}")
    public ResponseEntity<Contribution> findContributionResponseEntity(@PathVariable("id")Long id){
        return  new ResponseEntity<>(contributionService.findContributionById(id),HttpStatus.ACCEPTED);
    }
}
