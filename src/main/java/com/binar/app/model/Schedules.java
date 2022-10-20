package com.binar.app.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "schedules", schema = "public")
public class Schedules {

    @Id
    private Long schedule_id;

    private Long film_code;
    private String tanggal_tayang;
    private String jam_mulai;
    private String jam_selesai;
    private Integer harga_tiket;

}
