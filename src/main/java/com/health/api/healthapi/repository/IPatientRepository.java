package com.health.api.healthapi.repository;

import com.health.api.healthapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT p from Patient p WHERE p.user.id = ?1")
    List<Patient> selectPatientsByStaff(Long staffId);
}
