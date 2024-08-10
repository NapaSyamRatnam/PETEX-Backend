package com.petex.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.petex.entity.ReportEntity;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportServices {
	
	public String saveReport(ReportEntity entity,MultipartFile image)throws IOException;
	
	public List<ReportEntity> getAllReport();
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
