package in.petex.serviceimpl;

import java.io.File;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.petex.entity.FundingEntity;
import in.petex.repository.FundingRepository;
import in.petex.service.FundingService;
import in.petex.utils.EmailUtils;
import in.petex.utils.PdfGenerator;
import in.petex.utils.EmailUtils;

import jakarta.servlet.http.HttpServletResponse;



	@Service
	public class FundingServiceImpl implements FundingService {

	    @Autowired
	    private FundingRepository repo;
	    
	    @Autowired
		private EmailUtils emailUtils;

		@Autowired
		private PdfGenerator pdfGenrator;

	    @Override
	    public String saveReport(FundingEntity entity) {
	        if (entity == null) {
	            throw new IllegalArgumentException("Funding Entity cannot be null");
	        }

	        repo.save(entity);

	        return "Funding Report saved successfully";
	    }
	

	    @Override
		public boolean exportPdf(HttpServletResponse response) throws Exception {
			List<FundingEntity> report = repo.findAll();

			if (report.isEmpty()) {
				throw new Exception("No data found");
			}

			File f = new File("report.pdf");

			pdfGenrator.generate(response, report, f);
			String subject = "PET FUNDING";
			String body = "PET BODY";
			String to = "srikanthvk0@gmail.com";

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();
			return true;
		}


}
