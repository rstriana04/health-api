package com.health.api.healthapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    private String photo;

    public Patient() {
    }


    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 100) String getName() {
        return this.name;
    }

    public @NotBlank @Size(min = 3, message = "The lastName should have at least 3 characters", max = 100) String getLastName() {
        return this.lastName;
    }

    public @NotBlank String getPhone() {
        return this.phone;
    }

    public @NotBlank String getGender() {
        return this.gender;
    }

    public @NotBlank String getDateBirth() {
        return this.dateBirth;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 100) String name) {
        this.name = name;
    }

    public void setLastName(@NotBlank @Size(min = 3, message = "The lastName should have at least 3 characters", max = 100) String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public void setGender(@NotBlank String gender) {
        this.gender = gender;
    }

    public void setDateBirth(@NotBlank String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Patient)) return false;
        final Patient other = (Patient) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$dateBirth = this.getDateBirth();
        final Object other$dateBirth = other.getDateBirth();
        if (this$dateBirth == null ? other$dateBirth != null : !this$dateBirth.equals(other$dateBirth)) return false;
        final Object this$photo = this.getPhoto();
        final Object other$photo = other.getPhoto();
        if (this$photo == null ? other$photo != null : !this$photo.equals(other$photo)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Patient;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $dateBirth = this.getDateBirth();
        result = result * PRIME + ($dateBirth == null ? 43 : $dateBirth.hashCode());
        final Object $photo = this.getPhoto();
        result = result * PRIME + ($photo == null ? 43 : $photo.hashCode());
        return result;
    }

    public String toString() {
        return "Patient(id=" + this.getId() + ", name=" + this.getName() + ", lastName=" + this.getLastName() + ", phone=" + this.getPhone() + ", gender=" + this.getGender() + ", dateBirth=" + this.getDateBirth() + ", photo=" + this.getPhoto() + ")";
    }
}
