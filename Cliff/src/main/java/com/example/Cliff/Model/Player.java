package com.example.Cliff.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
@Validated
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id2;

    private String pname;
    private int age;
    private String created_at;
    private String updated_at;

    @ManyToOne
    @JsonBackReference
    private Team team;

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
