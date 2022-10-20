package com.binar.app.service;

import com.binar.app.dto.ScheduleDTO;
import com.binar.app.model.Schedules;
import com.binar.app.repository.ScheduleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedules create(Schedules films) {
        final Schedules result = scheduleRepository.save(films);
        return result;
    }

    @Override
    public Schedules update(Long schedule_id, Schedules schedule) {
        Schedules result = findById(schedule_id);
        if(result != null) {
            result.setTanggal_tayang(schedule.getTanggal_tayang());
            result.setJam_mulai(schedule.getJam_mulai());
            result.setJam_selesai(schedule.getJam_selesai());
            result.setHarga_tiket(schedule.getHarga_tiket());
            scheduleRepository.save(schedule);
        }
        return null;
    }

    @Override
    public Boolean delete(Long schedule_id) {
        final Schedules result = findById(schedule_id);
        if (result != null) {
            // hard delete
            scheduleRepository.deleteById(schedule_id);
            return true;
        }
        return false;
    }

    @Override
    public List<Schedules> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedules findById(Long schedule_id) {
        Optional<Schedules> result = scheduleRepository.findById(schedule_id);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ScheduleDTO mapToDto(Schedules schedules) {
        return mapper.convertValue(schedules, ScheduleDTO.class);
    }

    @Override
    public Schedules mapToEntity(ScheduleDTO scheduleDTO) {
        return mapper.convertValue(scheduleDTO, Schedules.class);
    }

}
