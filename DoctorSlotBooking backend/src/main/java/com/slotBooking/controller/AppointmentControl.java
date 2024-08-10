package com.slotBooking.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.slotBooking.entity.Appointment;
import com.slotBooking.service.SlotService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AppointmentControl {
	@Autowired
	private com.slotBooking.repo.AppointmentRepo appointmentRepository;

	@Autowired
	private SlotService services;

	@PostMapping("/save/{userId}")
	public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment, @PathVariable Long userId)
			throws DocumentException, IOException {

		Boolean savedAppointment = services.save(appointment, userId);
		if (savedAppointment) {
			return new ResponseEntity<>("Appointment suucessfully", HttpStatus.OK);

		}
		return new ResponseEntity<>("Apoointment not book", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> allApointment = services.getAll();
		return new ResponseEntity<>(allApointment, HttpStatus.OK);
	}

	@GetMapping("/checkAvailability")
	public ResponseEntity<List<String>> checkTimeSlotAvailability(@RequestParam String date) {
		List<String> bookedTimeSlots = appointmentRepository.findByBookingDate(date);
		List<String> allTimeSlots = Arrays.asList("10:00 AM", "10:20 AM", "10:40 AM", "11:00 AM", "11:20 AM",
				"11:40 AM", "12:00 PM", "12:20 PM", "12:40 PM", "2:00 PM", "2:20 PM", "2:40 PM", "3:00 PM", "3:20 PM",
				"3:40 PM", "4:00 PM", "4:20 PM", "4:40 PM", "5:00 PM", "5:20 PM");

		List<String> availableTimeSlots = allTimeSlots.stream().filter(timeSlot -> !bookedTimeSlots.contains(timeSlot))
				.collect(Collectors.toList());

		return new ResponseEntity<>(availableTimeSlots, HttpStatus.OK);
	}
	 @GetMapping("/doctor/{doctId}/{bookingDate}")
	    public List<Appointment> getAppointmentsByDoctIdAndBookingDate(@PathVariable String doctId, @PathVariable String bookingDate) {
	        return services.getAppointmentsByDoctIdAndBookingDate(doctId, bookingDate);
	    }
	 

	    @GetMapping("/doctor/{doctId}/service/{typeOfService}")
	    public List<Appointment> getAppointmentsByDoctIdAndTypeOfService(@PathVariable String doctId, @PathVariable String typeOfService) {
	        return services.getAppointmentsByDoctIdAndTypeOfService(doctId, typeOfService);
	    }
	    @DeleteMapping("/appointments/{id}")
	    public void deleteAppointmentById(@PathVariable Long id) {
	    	services.deleteAppointmentById(id);
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id) {
	        Appointment appointment = services.getById(id);
	        if (appointment != null) {
	            return new ResponseEntity<>(appointment, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
