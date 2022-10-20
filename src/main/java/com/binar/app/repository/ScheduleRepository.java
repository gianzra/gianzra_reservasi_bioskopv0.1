package com.binar.app.repository;

import com.binar.app.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

}
