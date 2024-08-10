package com.testReport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testReport.entity.TestReport;

public interface TestReportRepository extends JpaRepository<TestReport, Long> {

	  List<TestReport> findByUserId(Long userId);
	  
}
