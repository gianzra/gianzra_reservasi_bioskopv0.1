package com.binar.app.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "films", schema = "public")
public class Films {

    @Id
    private Long film_code;
    private String film_name;
    private Boolean is_showing;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "schedule_id")
//    private List<Schedules> schedules;

}
