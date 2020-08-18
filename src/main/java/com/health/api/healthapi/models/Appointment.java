package com.health.api.healthapi.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity()
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;


}
