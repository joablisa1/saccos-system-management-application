package com.saccossystemmanagement.repository;

import com.saccossystemmanagement.entities.ContributionIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionIncomeRepository extends JpaRepository<ContributionIncome,Long> {
}
