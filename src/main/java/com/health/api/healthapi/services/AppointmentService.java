package com.health.api.healthapi.services;

import com.health.api.healthapi.models.Appointment;
import com.health.api.healthapi.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private IAppointmentRepository iAppointmentRepository;


    public List<Appointment> getAllAppointments() {
        return iAppointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return iAppointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointmentsByUserId(Long userId) {
        return iAppointmentRepository.selectAppointmentsByStaffId(userId);
    }

    public void deleteAppointmentById(Long appointmentId) {
        iAppointmentRepository.deleteById(appointmentId);
    }

}
