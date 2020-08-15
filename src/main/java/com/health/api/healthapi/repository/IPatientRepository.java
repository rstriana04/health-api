package com.health.api.healthapi.repository;

import com.health.api.healthapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
