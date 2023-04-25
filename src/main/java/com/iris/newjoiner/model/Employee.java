package com.iris.newjoiner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "is_manager")
    @JsonProperty("is_manager")
    private boolean isManager;

    @Column(name = "is_hr_spocs")
    @JsonProperty("is_hr_spocs")
    private boolean isHRSpocs;

}
