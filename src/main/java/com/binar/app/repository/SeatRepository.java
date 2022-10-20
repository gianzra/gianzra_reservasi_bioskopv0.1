package com.binar.app.repository;

import com.binar.app.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seats, Integer> {


}
