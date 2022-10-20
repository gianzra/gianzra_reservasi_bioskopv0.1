package com.binar.app.service;

import com.binar.app.dto.SeatDTO;
import com.binar.app.model.Seats;
import com.binar.app.model.User;

import java.util.List;

public interface SeatService {

    List<Seats> findAll();
    Seats create(Seats seat);

    SeatDTO mapToDto(Seats seats);
    Seats mapToEntity(SeatDTO seatDTO);

}
