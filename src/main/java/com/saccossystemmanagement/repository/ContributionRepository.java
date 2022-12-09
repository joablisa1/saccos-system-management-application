package com.saccossystemmanagement.repository;

import com.saccossystemmanagement.model.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository  extends JpaRepository<Contribution,Long> {
    List<Contribution> findAllByMonthlyContribution(Double monthlyContribution);


}
