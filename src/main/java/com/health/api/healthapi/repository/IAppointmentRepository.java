package com.health.api.healthapi.repository;

import com.health.api.healthapi.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT a FROM Appointment a WHERE a.user.id = ?1")
    List<Appointment> selectAppointmentsByStaffId(Long staffId);
}
