package com.binar.app.controller;

import com.binar.app.dto.ScheduleDTO;
import com.binar.app.model.Schedules;
import com.binar.app.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/create")
    public ScheduleDTO create(@RequestBody ScheduleDTO request) {
        final Schedules schedule = scheduleService.mapToEntity(request);
        final Schedules result = scheduleService.create(schedule);
        return scheduleService.mapToDto(result);
    }

    @PutMapping("update/{schedule_id}")
    public ScheduleDTO update(@PathVariable Long scheduleId, @RequestBody ScheduleDTO request) {
        final Schedules schedule = scheduleService.mapToEntity(request);
        final Schedules result = scheduleService.update(scheduleId, schedule);
        return scheduleService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<ScheduleDTO> findAll() {
        return scheduleService.findAll().stream().map(schedule -> scheduleService.mapToDto(schedule)).toList();
    }

    @DeleteMapping("/delete/{schedule_id}")
    public Boolean delete(@PathVariable Long scheduleId) {
        return scheduleService.delete(scheduleId);
    }

}
