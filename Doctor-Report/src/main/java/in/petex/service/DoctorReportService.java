package in.petex.service;





import java.time.LocalDate;
import java.util.List;






import in.petex.entity.DoctorReportEntity;

public interface DoctorReportService {

	public Boolean save(DoctorReportEntity report);

	void delete(Long customerId);

	public DoctorReportEntity getReportById(Long customerId);

	public List<DoctorReportEntity> getAllReport();
	
	
	
	 List<DoctorReportEntity> findByDate(LocalDate date);

	    List<DoctorReportEntity> findByMonth(int month);

	    List<DoctorReportEntity> findByYear(int year);

	    List<DoctorReportEntity> findByMonthAndYear(int month, int year);
	    
	    List<DoctorReportEntity> getDoctorReportsByGender(String gender);

	   


	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}


