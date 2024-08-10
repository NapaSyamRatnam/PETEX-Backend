package com.testReport.service;

import java.io.IOException;
import java.util.List;

import com.testReport.entity.TestReport;

public interface TestReportService {
	public Boolean save(TestReport entity, Long vacId, Long docId) throws IOException;

	List<TestReport> getAllTestReports();

	TestReport getTestReportById(Long testid);
	  public List<TestReport> getByUserId(Long userId);
	
}
