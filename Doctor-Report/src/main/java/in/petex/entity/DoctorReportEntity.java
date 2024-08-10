package in.petex.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// PetexDoctorReport

@Entity
@Table(name = "doctor_report_table")
public class DoctorReportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	private String customerName;
	
	private String gender;

	private String customerEmail;

	private Long customerPhno;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@JsonFormat(pattern = "H:mm")
	private LocalTime time;

	
	

	public DoctorReportEntity() {
	super();
	}

	public DoctorReportEntity(Long customerId, String customerName, String customerEmail, Long customerPhno,
			LocalDate date,String gender,LocalTime time) {
	super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhno = customerPhno;
		this.date = date;
		this.gender = gender;
		this.time = time;
		
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerPhno() {
		return customerPhno;
	}

	public void setCustomerPhno(Long customerPhno) {
		this.customerPhno = customerPhno;
	}

	 public CharSequence getDate() {
	        return date.toString();
	    }

	    public void setDate(String date) {
	        this.date = LocalDate.parse(date); 
	        
	    }
	
	
	    
}