package com.binar.app.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "schedules", schema = "public")
public class Schedules {

    @Id
    private Long scheduleId;

    private Long filmCode;
    private String tanggalTayang;
    private String jamMulai;
    private String jamSelesai;
    private Integer hargaTiket;

}
