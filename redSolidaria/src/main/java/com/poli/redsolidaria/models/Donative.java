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

    @ManyToOne //Muchos donativos pertenecen a un solo usuario
    @JoinColumn(name = "user_id", nullable = false)
    private User idUser;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "category", length = 100, nullable = false)
    private String category;

    @Column(name = "date", nullable = false)
    private LocalDateTime donativeDate;

    @Column(name = "Available", nullable = false)
    private Boolean Available;

}