package com.health.api.healthapi.controllers;


import com.health.api.healthapi.models.Appointment;
import com.health.api.healthapi.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/appointments/staff/{staffId}")
    public List<Appointment> getAllAppointmentsByStaff(@PathVariable Long staffId) {
        return appointmentService.getAllAppointmentsByUserId(staffId);
    }


}
