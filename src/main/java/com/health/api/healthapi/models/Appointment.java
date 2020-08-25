package com.health.api.healthapi.models;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity()
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String citationType;

    @NotBlank
    private String citation;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private User user;


    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;


}
