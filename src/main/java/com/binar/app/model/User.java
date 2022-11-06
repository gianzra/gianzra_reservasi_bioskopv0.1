package com.binar.app.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private Long id;

    private String username;
    private String emailAddress;
    private String password;

}
