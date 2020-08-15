package com.health.api.healthapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames =
        "username")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "The username should have at least 3 characters", max = 100)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, message = "The name should have at least 3 characters", max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, message = "The name should have at least 3 characters", max = 50)
    private String lastName;

    @NotBlank
    private String dateBirth;

    private String phone;

    @NotBlank
    private String gender;

    @NotBlank
    private String dni;

    @NotBlank
    @Size(min = 7, message = "password should have at least 7 characters", max = 100)
    @JsonIgnore
    private String password;

    private String accessToken;

    public User() {
    }

    public User(
            String username,
            String email,
            String name,
            String lastName,
            String dateBirth,
            String phone,
            String gender,
            String dni,
            String password
    ) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.gender = gender;
        this.dni = dni;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 3, message = "The username should have at least 3 characters", max = 100) String getUsername() {
        return this.username;
    }

    public @NotBlank @Email String getEmail() {
        return this.email;
    }

    public @NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 50) String getName() {
        return this.name;
    }

    public @NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 50) String getLastName() {
        return this.lastName;
    }

    public @NotBlank String getDateBirth() {
        return this.dateBirth;
    }

    public String getPhone() {
        return this.phone;
    }

    public @NotBlank String getGender() {
        return this.gender;
    }

    public @NotBlank String getDni() {
        return this.dni;
    }

    public @NotBlank @Size(min = 7, message = "password should have at least 7 characters", max = 100) String getPassword() {
        return this.password;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(@NotBlank @Size(min = 3, message = "The username should have at least 3 characters", max = 100) String username) {
        this.username = username;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public void setName(@NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 50) String name) {
        this.name = name;
    }

    public void setLastName(@NotBlank @Size(min = 3, message = "The name should have at least 3 characters", max = 50) String lastName) {
        this.lastName = lastName;
    }

    public void setDateBirth(@NotBlank String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(@NotBlank String gender) {
        this.gender = gender;
    }

    public void setDni(@NotBlank String dni) {
        this.dni = dni;
    }

    public void setPassword(@NotBlank @Size(min = 7, message = "password should have at least 7 characters", max = 100) String password) {
        this.password = password;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$dateBirth = this.getDateBirth();
        final Object other$dateBirth = other.getDateBirth();
        if (this$dateBirth == null ? other$dateBirth != null : !this$dateBirth.equals(other$dateBirth)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        final Object this$dni = this.getDni();
        final Object other$dni = other.getDni();
        if (this$dni == null ? other$dni != null : !this$dni.equals(other$dni)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$accessToken = this.getAccessToken();
        final Object other$accessToken = other.getAccessToken();
        if (this$accessToken == null ? other$accessToken != null : !this$accessToken.equals(other$accessToken))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $dateBirth = this.getDateBirth();
        result = result * PRIME + ($dateBirth == null ? 43 : $dateBirth.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        final Object $dni = this.getDni();
        result = result * PRIME + ($dni == null ? 43 : $dni.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $accessToken = this.getAccessToken();
        result = result * PRIME + ($accessToken == null ? 43 : $accessToken.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", email=" + this.getEmail() + ", name=" + this.getName() + ", lastName=" + this.getLastName() + ", dateBirth=" + this.getDateBirth() + ", phone=" + this.getPhone() + ", gender=" + this.getGender() + ", dni=" + this.getDni() + ", password=" + this.getPassword() + ", accessToken=" + this.getAccessToken() + ")";
    }
}
