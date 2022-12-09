package com.saccossystemmanagement.service;

import com.saccossystemmanagement.entities.ContributionIncome;
import com.saccossystemmanagement.model.Contribution;
import com.saccossystemmanagement.model.Payment;
import com.saccossystemmanagement.repository.ContributionIncomeRepository;
import com.saccossystemmanagement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionInComeService {
    @Autowired ContributionService contributionService;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ContributionIncomeRepository contributionIncomeRepository;

    public void saveContributionIncome(ContributionIncome contributionIncome){
        List<Payment> payments=paymentRepository.findAll();
        List<Contribution> contributionList=contributionService.findAllContributionList();
//         totalOrgannizationIncome=0.0;
        double totalOrgannizationBalance=0.0;
        for (Payment payment:payments){
            totalOrgannizationBalance += payment.getAmount();
        }
        contributionIncome.setTotalIncome(totalOrgannizationBalance);
        double sumregistrationFee=0.0;
        for (Contribution contribution:contributionList){
            sumregistrationFee+=contribution.getFeeCharges();
        }
        contributionIncome.setTotalRegistrationFee(sumregistrationFee);

        double totalIBalance=totalOrgannizationBalance + sumregistrationFee;
        contributionIncome.setTotalBalance(totalIBalance);
        contributionIncomeRepository.save(contributionIncome);
    }


    public void totalOrganizationIncomeBalance(double totalIncome){
        ContributionIncome contributionIncome =new ContributionIncome();
        List<Payment> payments=paymentRepository.findAll();
        List<Contribution> contributionList=contributionService.findAllContributionList();
        double income=0.0;
        for (Payment payment:payments){
            income += payment.getAmount();
        }
        double sum=0.0;
        for (Contribution contribution:contributionList){
            sum=contribution.getFeeCharges();
        }

        double sumMonthlyContribution=0.0;
        for (Contribution contribution:contributionList){
            sum=contribution.getMonthlyContribution();
        }
        totalIncome=income + sum +sumMonthlyContribution;
        contributionIncome.setTotalIncome(totalIncome);
    }



}
