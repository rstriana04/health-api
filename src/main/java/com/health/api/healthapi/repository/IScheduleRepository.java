package com.health.api.healthapi.repository;

import com.health.api.healthapi.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT s FROM Schedule s WHERE s.user.id = ?1")
    List<Schedule> selectSchedulesByStaff(Long staffId);
}
