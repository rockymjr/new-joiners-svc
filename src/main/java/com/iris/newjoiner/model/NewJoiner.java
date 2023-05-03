package com.iris.newjoiner.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "new_joiners")
public class NewJoiner {

    @Id
    private int id;
    private String name;
    private String email;
    private String contactNumber;
    private Date joiningDate;
    private Date lastFollowUpDate;
    private String inductionStatus;
    private String projectName;
    private Date projectAllocationDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "hr_spocs_id")
    private Employee hrSpoc;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

}
