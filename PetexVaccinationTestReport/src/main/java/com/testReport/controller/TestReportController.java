package com.testReport.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testReport.entity.TestReport;
import com.testReport.service.TestReportService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/petex")
public class TestReportController {

    @Autowired
    private TestReportService testReportService;

    @PostMapping("/save/{vacId}/{docId}") 
    public ResponseEntity<String> saveHome(@RequestBody TestReport entity,@PathVariable Long vacId,@PathVariable Long docId) throws IOException {
        Boolean status = testReportService.save(entity, vacId, docId);
        if (status) {
            return new ResponseEntity<String>("Test Report data save successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Test Report data not save successfully", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all")
    public List<TestReport> getAllTestReports() {
        return testReportService.getAllTestReports();
    }

    @GetMapping("/{id}")
    public TestReport getTestReportById(@PathVariable("id") Long id) {
        return testReportService.getTestReportById(id);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TestReport>> getByUserId(@PathVariable Long userId) {
        List<TestReport> testReports = testReportService.getByUserId(userId);
        return new ResponseEntity<>(testReports, HttpStatus.OK);
    }

  
}

