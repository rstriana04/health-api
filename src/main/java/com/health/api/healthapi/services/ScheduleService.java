package com.health.api.healthapi.services;

import com.health.api.healthapi.models.Schedule;
import com.health.api.healthapi.repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScheduleService {
    @Autowired
    private IScheduleRepository iScheduleRepository;


    public List<Schedule> getAllSchedules() {
        return iScheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return iScheduleRepository.findById(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        return iScheduleRepository.save(schedule);
    }

    public List<Schedule> createSchedules(List<Schedule> schedules) {
        return iScheduleRepository.saveAll(schedules);
    }

    public List<Schedule> getSchedulesByStaffId(Long staffId) {
        return iScheduleRepository.selectSchedulesByStaff(staffId);
    }
}
