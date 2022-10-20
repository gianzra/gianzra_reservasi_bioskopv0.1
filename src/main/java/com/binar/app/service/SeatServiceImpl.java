package com.binar.app.service;

import com.binar.app.dto.SeatDTO;
import com.binar.app.model.Seats;
import com.binar.app.model.User;
import com.binar.app.repository.SeatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seats create(Seats seat) {
        final Seats result = seatRepository.save(seat);
        return result;
    }

    @Override
    public List<Seats> findAll() {
        return seatRepository.findAll();
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public SeatDTO mapToDto(Seats schedules) {
        return mapper.convertValue(schedules, SeatDTO.class);
    }

    @Override
    public Seats mapToEntity(SeatDTO seatDTO) {
        return mapper.convertValue(seatDTO, Seats.class);
    }

}
