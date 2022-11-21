package com.binar.user.model;

import lombok.*;

import javax.persistence.*;

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
