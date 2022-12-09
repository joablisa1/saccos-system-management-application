package com.saccossystemmanagement.service;

import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.model.Contribution;
import com.saccossystemmanagement.model.Loans;
import com.saccossystemmanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired ContributionService contributionService;
    @Autowired CategoryService categoryService;
    @Autowired
    LoanRepository loanRepository;

    public void saveLoan(Loans loans){
        Category category=new Category();
        List<Contribution> continuations=contributionService.findAllContributionList();
        double principalAmount=0.0;
        for (Contribution contribution:continuations){
             principalAmount+=contribution.getMonthlyContribution();
        }
        loans.setTotalMonthlyContribution(principalAmount);
        double principal=principalAmount/3;
        loans.setPrincipalAmount(principal);
        double amount=0.0;
        amount=principalAmount-500;
        loans.setBorrowedAmount(amount);
        loanRepository.save(loans);
    }

}
