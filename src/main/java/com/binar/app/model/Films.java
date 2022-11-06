package com.binar.app.model;

import javax.persistence.*;
import lombok.*;



@Getter
@Setter
@Entity
@Table(name = "films", schema = "public")
public class Films {

    @Id
    private Long filmCode;
    private String filmName;
    private Boolean isShowing;




}
