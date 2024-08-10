package in.petex.controller;



	



import java.time.LocalDate;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import in.petex.entity.DoctorReportEntity;
import in.petex.service.DoctorReportService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reports")
public class DoctorReportController {
	
	@Autowired
	private DoctorReportService doctorreportservice;
	@PostMapping("/reportsave")
	 public ResponseEntity<String> save(@RequestBody DoctorReportEntity report) {
	        try {
	            Boolean status = doctorreportservice.save(report);
	            if (status) {
	                return new ResponseEntity<>("Data is saved successfully", HttpStatus.CREATED);
	            } else {
	                return new ResponseEntity<>("Data is not saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>("Invalid data or format", HttpStatus.BAD_REQUEST);
	        }
	    }
	
	
	 
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> delete(@PathVariable Long customerId) {

		doctorreportservice.delete(customerId);

		return new ResponseEntity<>("Report deleted successfully", HttpStatus.OK);

	}

	@GetMapping("/{customerId}")
	public ResponseEntity<DoctorReportEntity> getBreedById(@PathVariable Long customerId) {
		DoctorReportEntity report = doctorreportservice.getReportById(customerId);
		if (report != null) {
			return new ResponseEntity<>(report, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<java.util.List<DoctorReportEntity>> getAllReport() {
		java.util.List<DoctorReportEntity> reportList = doctorreportservice.getAllReport();
		return new ResponseEntity<>(reportList, HttpStatus.OK);
	}


	    
	 @GetMapping("/date/{date}")
	    public ResponseEntity<List<DoctorReportEntity>> getReportsByDate(@PathVariable("date") String dateString) {
	        // Parse the date string to LocalDate
	        LocalDate date = LocalDate.parse(dateString);

	        // Call the service method to get reports for the given date
	        List<DoctorReportEntity> reports = doctorreportservice.findByDate(date);

	        // Return the response
	        return new ResponseEntity<>(reports, HttpStatus.OK);
	    }

	    @GetMapping("/month/{month}")
	    public ResponseEntity<List<DoctorReportEntity>> getReportsByMonth(@PathVariable("month") int month) {
	    	
	        // Call the service method to get reports for the given month
	        List<DoctorReportEntity> reports = doctorreportservice.findByMonth(month);

	        // Return the response
	        return new ResponseEntity<>(reports, HttpStatus.OK);
	    }

	    @GetMapping("/year/{year}")
	    public ResponseEntity<List<DoctorReportEntity>> getReportsByYear(@PathVariable("year") int year) {
	        // Call the service method to get reports for the given year
	        List<DoctorReportEntity> reports = doctorreportservice.findByYear(year);

	        // Return the response
	        return new ResponseEntity<>(reports, HttpStatus.OK);
	    }

	    @GetMapping("/monthyear/{month}/{year}")
	    public ResponseEntity<List<DoctorReportEntity>> getReportsByMonthAndYear(
	            @PathVariable("month") int month,
	            @PathVariable("year") int year) {
	        // Call the service method to get reports for the given month and year
	        List<DoctorReportEntity> reports = doctorreportservice.findByMonthAndYear(month, year);

	        // Return the response
	        return new ResponseEntity<>(reports, HttpStatus.OK);
	    }
    
	    
	    
	    @GetMapping("/gender/{gender}")
	    public ResponseEntity<List<DoctorReportEntity>> getDoctorReportsByGender(@PathVariable String gender) {
	        List<DoctorReportEntity> doctorReports = doctorreportservice.getDoctorReportsByGender(gender);
	        return new ResponseEntity<>(doctorReports, HttpStatus.OK);
	    }
    
	    
	    
	    
	    
	    
	    
	    
	    
}

