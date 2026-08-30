package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Appointments;
import com.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class AppointmentsController {

    private final AppointmentsRepository appointmentRepository;

    public AppointmentsController(AppointmentsRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Create Appointment
    @PostMapping("/insert")
    public Appointments createAppointments(@RequestBody Appointments appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get All Appointments
    @GetMapping("/appointments")
    public List<Appointments> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Delete Appointment by ID
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean >> deleteAppointment(@PathVariable Long id)
            throws AttributeNotFoundException {

        Appointments appointment = appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new AttributeNotFoundException("Appointment not found with id: " + id));

        appointmentRepository.delete(appointment);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }
}