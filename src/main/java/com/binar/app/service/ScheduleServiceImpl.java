package com.binar.app.service;

import com.binar.app.dto.ScheduleDTO;
import com.binar.app.model.Schedules;
import com.binar.app.repository.ScheduleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
            logger.info("Data schedules tersedia");
            result.setTanggal_tayang(schedule.getTanggal_tayang());
            result.setJam_mulai(schedule.getJam_mulai());
            result.setJam_selesai(schedule.getJam_selesai());
            result.setHarga_tiket(schedule.getHarga_tiket());
            scheduleRepository.save(schedule);
        }else {
            logger.error("Data schedules tidak tersedia");
        }
        return null;
    }

    @Override
    public Boolean delete(Long schedule_id) {
        final Schedules result = findById(schedule_id);
        if (result != null) {
            logger.info("Menghapus data schedules dari database");
            // hard delete
            scheduleRepository.deleteById(schedule_id);
            return true;
        }else {
            logger.error("Data schedules tidak tersedia");
        }
        return false;
    }

    @Override
    public List<Schedules> findAll() {
        logger.info("Mengambil data schedules dari database");
        return scheduleRepository.findAll();
    }

    @Override
    public Schedules findById(Long schedule_id) {
        Optional<Schedules> result = scheduleRepository.findById(schedule_id);
        if(result.isPresent()) {
            logger.info("Data schedules tersedia");
            return result.get();
        }else {
            logger.error("Data schedules tidak dimasukkan");
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
