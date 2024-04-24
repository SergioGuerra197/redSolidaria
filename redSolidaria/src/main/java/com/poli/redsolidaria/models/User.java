package com.poli.redsolidaria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")

public class User {

    @Id
    private Long id;

    @Column(name = "username", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "contact_number", length = 20, nullable = false)
    private Integer contactNumber;

    @Column(name = "rol", length = 100, nullable = false)
    private Integer rol;

}