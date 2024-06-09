package com.poli.redsolidaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "donatives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    private String idUser;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "amount", length = 100, nullable = false)
    private Integer amount;

    @Column(name = "image", length = 200, nullable = false)
    private String image;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "donativeCondition", length = 100)
    private String donativeCondition;

    @Column(name = "date", nullable = false)
    private LocalDateTime donativeDate;

    @Column(name = "available", nullable = false)
    private Boolean available;

}