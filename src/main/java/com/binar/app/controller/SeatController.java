package com.binar.app.controller;

import com.binar.app.dto.ScheduleDTO;
import com.binar.app.dto.SeatDTO;
import com.binar.app.model.Schedules;
import com.binar.app.model.Seats;
import com.binar.app.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    SeatService seatService;

    @PostMapping("/create")
    public SeatDTO create(@RequestBody SeatDTO request) {
        final Seats schedule = seatService.mapToEntity(request);
        final Seats result = seatService.create(schedule);
        return seatService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<SeatDTO> findAll() {
        return seatService.findAll().stream().map(schedule -> seatService.mapToDto(schedule)).toList();
    }

}
