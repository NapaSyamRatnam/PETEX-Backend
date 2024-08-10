package com.slotBooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.slotBooking.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    List<String> findByBookingDate(String date);
    List<Appointment> findByDoctIdAndBookingDate(String doctId, String bookingDate);
    @Query("SELECT a FROM Appointment a WHERE a.doctId = :doctId AND a.typeOfService = :typeOfService")
    List<Appointment> findByDoctIdAndTypeOfService(@Param("doctId") String doctId, @Param("typeOfService") String typeOfService);

}
