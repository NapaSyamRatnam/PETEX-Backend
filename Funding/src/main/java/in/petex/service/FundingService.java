package in.petex.service;



import in.petex.entity.FundingEntity;
import jakarta.servlet.http.HttpServletResponse;



public interface FundingService {
	
	public String saveReport(FundingEntity entity);
	
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
