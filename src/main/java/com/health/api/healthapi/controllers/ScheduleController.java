package com.health.api.healthapi.controllers;

import com.health.api.healthapi.models.Schedule;
import com.health.api.healthapi.services.ScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules() {
        return scheduleService.getAllSchedules();
    }


    @GetMapping("/schedules/{id}")
    public Optional<Schedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @GetMapping("/schedules/staff/{staffId}")
    public List<Schedule> getSchedulesByStaffId(@PathVariable Long staffId) {
        return scheduleService.getSchedulesByStaffId(staffId);
    }

    @PutMapping("/schedules")
    public Schedule updateSchedule(@RequestBody @Valid Schedule schedule) {
        try {
            Optional<Schedule> scheduleOptional = scheduleService.getScheduleById(schedule.getId());
            if (!scheduleOptional.isPresent()) {
                return null;
            }
            schedule.setId(schedule.getId());
            return scheduleService.createSchedule(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/schedules")
    public List<Schedule> createSchedules(@RequestBody @Valid List<Schedule> schedules) {
        return scheduleService.createSchedules(schedules);
    }

}
