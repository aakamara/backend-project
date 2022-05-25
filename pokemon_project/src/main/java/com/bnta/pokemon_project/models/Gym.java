package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "trainers_gyms",
            joinColumns = {@JoinColumn(name = "gym_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "trainer_id", nullable = false)}
    )
    @JsonIgnoreProperties({"gym_badges"})
    private List<Trainer> trainers;

    @OneToOne(mappedBy = "gym")
    @JsonIgnoreProperties({"gym"})
    private GymLeader gymLeader;

//    CONSTRUCTORS
    public Gym(String name, List<Trainer> trainers) {
        this.name = name;
        this.trainers = trainers;
    }

    public Gym () {}

//    GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public GymLeader getGymLeader() {
        return gymLeader;
    }

    public void setGymLeader(GymLeader gymLeader) {
        this.gymLeader = gymLeader;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainers=" + trainers +
                ", gymLeader=" + gymLeader +
                '}';
    }
}
