package com.health.api.healthapi.controllers;

import com.health.api.healthapi.models.Patient;
import com.health.api.healthapi.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{staffId}")
    public List<Patient> getPatientsByStaff(@PathVariable Long staffId) {
        return patientService.getAllPatientByStaff(staffId);
    }

//    @GetMapping("/patients/{patientId}")
//    public Optional<Patient> getPatientById(@PathVariable Long patientId) {
//        return patientService.getPatientById(patientId);
//    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody @Valid Patient patient) {
        try {
            Optional<Patient> patientOptional = patientService.getPatientById(patient.getId());
            if (!patientOptional.isPresent()) {
                return null;
            }
            patient.setId(patient.getId());
            return patientService.createPatient(patient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/patients")
    public Patient createPatient(@RequestBody @Valid Patient patient) {
        return patientService.createPatient(patient);
    }


    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long patientId) {
        try {
            patientService.deletePatientById(patientId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
