package com.saccossystemmanagement.controller;

import com.saccossystemmanagement.entities.ContributionIncome;
import com.saccossystemmanagement.service.ContributionInComeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContributionIncomController {
    @Autowired
    ContributionInComeService contributionInComeService;
    @GetMapping("/income")
    public ResponseEntity<ContributionIncome> contributionIncomeResponseEntity(@RequestBody ContributionIncome contributionIncome){
        contributionInComeService.saveContributionIncome(contributionIncome);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
