package com.saccossystemmanagement.service;

import com.saccossystemmanagement.model.Contribution;
import com.saccossystemmanagement.model.Customer;
import com.saccossystemmanagement.repository.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContributionService {

    @Autowired
    ContributionRepository contributionRepository;

    @Autowired CustomerService customerService;

    public List<Contribution> findAllContributionList(){
        return  contributionRepository.findAll();
    }
    public Contribution  saveContribution(Contribution contribution, Customer customer){

        contribution.setCustomer(customer);

        return contributionRepository.save(contribution);
    }
    public Contribution updateContribution(Contribution contribution,Customer customer){

        contribution.setCustomer(customer);
        return contributionRepository.save(contribution);
    }
    public Contribution findContributionById(Long id){
        return contributionRepository.findById(id).get();
    }
}
