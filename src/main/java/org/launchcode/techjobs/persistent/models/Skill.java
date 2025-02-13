package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @ManyToMany(mappedBy="skills")
    List<Job> jobs = new ArrayList<>();

    @NotNull
    @NotBlank
    @Size(max=500, min= 3)
    private String description;

    public Skill() {
    }

    public @NotNull @Size(max = 1000, message = "Character limit: 1000") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Size(max = 1000, message = "Character limit: 1000") String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}