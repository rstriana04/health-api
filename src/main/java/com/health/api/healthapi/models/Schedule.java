package com.health.api.healthapi.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String date_from;

    @NotBlank
    private String date_until;

    @NotBlank
    private Integer interval;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private User user;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Schedule() {
    }


    public Long getId() {
        return this.id;
    }

    public @NotBlank String getDate_from() {
        return this.date_from;
    }

    public @NotBlank String getDate_until() {
        return this.date_until;
    }

    public @NotBlank Integer getInterval() {
        return this.interval;
    }

    public User getUser() {
        return this.user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate_from(@NotBlank String date_from) {
        this.date_from = date_from;
    }

    public void setDate_until(@NotBlank String date_until) {
        this.date_until = date_until;
    }

    public void setInterval(@NotBlank Integer interval) {
        this.interval = interval;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Schedule)) return false;
        final Schedule other = (Schedule) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$date_from = this.getDate_from();
        final Object other$date_from = other.getDate_from();
        if (this$date_from == null ? other$date_from != null : !this$date_from.equals(other$date_from)) return false;
        final Object this$date_until = this.getDate_until();
        final Object other$date_until = other.getDate_until();
        if (this$date_until == null ? other$date_until != null : !this$date_until.equals(other$date_until))
            return false;
        final Object this$interval = this.getInterval();
        final Object other$interval = other.getInterval();
        if (this$interval == null ? other$interval != null : !this$interval.equals(other$interval)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Schedule;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date_from = this.getDate_from();
        result = result * PRIME + ($date_from == null ? 43 : $date_from.hashCode());
        final Object $date_until = this.getDate_until();
        result = result * PRIME + ($date_until == null ? 43 : $date_until.hashCode());
        final Object $interval = this.getInterval();
        result = result * PRIME + ($interval == null ? 43 : $interval.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    public String toString() {
        return "Schedule(id=" + this.getId() + ", date_from=" + this.getDate_from() + ", date_until=" + this.getDate_until() + ", interval=" + this.getInterval() + ", user=" + this.getUser() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
