package com.binar.app.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "seats", schema = "public")
public class Seats {

    @Id
    private Integer noKursi;
    private Character studioName;


}
