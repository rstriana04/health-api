package com.health.api.healthapi.services;

import com.health.api.healthapi.models.Patient;
import com.health.api.healthapi.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class PatientService {
    @Autowired
    private IPatientRepository iPatientRepository;


    public List<Patient> getAllPatients() {
        return iPatientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return iPatientRepository.findById(id);
    }

    public void deletePatientById(Long patientId) {
        iPatientRepository.deleteById(patientId);
    }


    public Patient createPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }

    public List<Patient> getAllPatientByStaff(Long staffId) {
        return iPatientRepository.selectPatientsByStaff(staffId);
    }


}
