package com.testReport.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testReport.entity.DoctorEntity;
import com.testReport.entity.TestReport;
import com.testReport.repository.DoctorSinghUpRepo;
import com.testReport.repository.TestReportRepository;



@Service
public class TestReportServiceImpl implements TestReportService {

    @Autowired
    private TestReportRepository testReportRepository;
    
 
    
    
    
    @Autowired
    private DoctorSinghUpRepo docRepo; 
    
    @Override
	public Boolean save(TestReport entity, Long vacId, Long docId) throws IOException{
    	
    
    	 Optional<DoctorEntity> optinalDoc = docRepo.findById(docId);
        
        if ( optinalDoc.isPresent()) {
        
        	DoctorEntity doctor = optinalDoc.get();
        	
        
        	entity.setDoctor(doctor);
            testReportRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<TestReport> getAllTestReports() {
        return testReportRepository.findAll();
    }

    @Override
    public TestReport getTestReportById(Long testid) {
        Optional<TestReport> optionalTestReport = testReportRepository.findById(testid);
        return optionalTestReport.orElse(null);
    }
    
    @Override
    public List<TestReport> getByUserId(Long userId) {
        return testReportRepository.findByUserId(userId);
    }

   

}

