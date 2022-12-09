package com.saccossystemmanagement.schedules;

import com.saccossystemmanagement.entities.ContributionIncome;
import com.saccossystemmanagement.model.Loans;
import com.saccossystemmanagement.repository.ContributionIncomeRepository;
import com.saccossystemmanagement.service.ContributionInComeService;
import com.saccossystemmanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ContributionSchedules {
    @Autowired
    ContributionInComeService contributionInComeService;
    @Autowired
    LoanService loanService;
    @Scheduled(fixedDelay = 60 * 1000, initialDelay = 1000)
    public  void cronJobShedules(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Application cron job Running:: " + strDate);
        ContributionIncome contributionIncome=new ContributionIncome();
        contributionInComeService.saveContributionIncome(contributionIncome);
        System.out.println("Application running" + contributionIncome);

        Loans loans=new Loans();
        loanService.saveLoan(loans);
        System.out.println("Run Loans"+ loans);

    }

}
