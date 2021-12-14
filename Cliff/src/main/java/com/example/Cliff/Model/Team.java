package com.example.Cliff.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Validated
@AllArgsConstructor
@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @NotNull
    private long id;

    @NotEmpty(message = "Name can't be empty!")
    private String name;

    private String location;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @PrePersist
    public void onInsert(){created_at = new Date();}

    public Team() {
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @JsonManagedReference
    private List<Player> player;

    public Team(long id, String name, String location, Date created_at, LocalDateTime updated_at) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
