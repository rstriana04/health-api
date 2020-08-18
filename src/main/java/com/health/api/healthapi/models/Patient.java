package com.health.api.healthapi.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(min = 3, message = "The name should have at least 3 characters", max = 100)
    private String name;

    @NotBlank
    @Size(min = 3, message = "The lastName should have at least 3 characters", max = 100)
    private String lastName;

    @NotBlank
    private String phone;

    @NotBlank
    private String gender;

    @NotBlank
    private String dateBirth;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = true)
    private User user;

}
