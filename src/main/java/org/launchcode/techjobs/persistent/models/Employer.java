package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @NotNull
    @Size(max=500, min= 3)
    public String location;

    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer(String location) {
        super();
        this.location = location;
    }
    //no-arg constructor
    public Employer() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public @NotBlank @NotNull @Size(max = 500, min = 3) String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank @NotNull @Size(max = 500, min = 3) String location) {
        this.location = location;
    }
}
