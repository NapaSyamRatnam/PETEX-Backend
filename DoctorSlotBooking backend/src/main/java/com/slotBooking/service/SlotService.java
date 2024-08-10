package com.slotBooking.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.slotBooking.entity.Appointment;
import com.slotBooking.entity.UserEntity;
import com.slotBooking.repo.AppointmentRepo;
import com.slotBooking.repo.UserRepository;
import com.slotBooking.utils.EmailUtils;
import com.slotBooking.utils.PdfGenerator;

@Service
public class SlotService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private PdfGenerator pdfGenerator;

	public Boolean save(Appointment entity, Long userId) throws DocumentException, IOException {

		UserEntity user = userRepo.findById(userId).orElse(null);
		if (user == null) {
			return false;
		}
		entity.setUser(user);

		Appointment save = appointmentRepo.save(entity);
		File f = new File("Appointment.pdf");

		pdfGenerator.generate( save, f);

		String subject = "Appointment Booking Report";
		String body = "Appointment ";
		String to = user.getEmail();
		

		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}
	
	public List<Appointment>getAll(){
		return appointmentRepo.findAll();
		
	}
	
	  public List<Appointment> getAppointmentsByDoctIdAndBookingDate(String doctId, String bookingDate) {
	        return appointmentRepo.findByDoctIdAndBookingDate(doctId, bookingDate);
	    }
	
	  public List<Appointment> getAppointmentsByDoctIdAndTypeOfService(String doctId, String typeOfService) {
	        return appointmentRepo.findByDoctIdAndTypeOfService(doctId, typeOfService);
	    }
	  
	 
	    public void deleteAppointmentById(Long id) {
	    	appointmentRepo.deleteById(id);
	    }
	    public Appointment getById(Long id) {
	        return appointmentRepo.findById(id).orElse(null);
	    }
}
