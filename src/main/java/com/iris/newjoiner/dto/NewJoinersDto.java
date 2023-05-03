package com.iris.newjoiner.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.iris.newjoiner.model.NewJoiner;
import lombok.Data;

import java.sql.Date;

@Data
public class NewJoinersDto {

    private String name;
    private String email;
    private String contactNumber;
    private Date joiningDate;
    private Date lastFollowUpDate;
    private String inductionStatus;
    private String projectName;
    private Date projectAllocationDate;
    private String status;

    @JsonProperty("hr_spocs_id")
    private Integer hrSpocId;

    @JsonProperty("manager_id")
    private Integer managerId;

    public NewJoiner getNewJoiner() {
        NewJoiner newJoiners = new NewJoiner();
        newJoiners.setName(this.name);
        newJoiners.setEmail(this.email);
        newJoiners.setContactNumber(this.contactNumber);
        newJoiners.setJoiningDate(this.joiningDate);
        newJoiners.setLastFollowUpDate(this.lastFollowUpDate);
        newJoiners.setInductionStatus(this.inductionStatus);
        newJoiners.setProjectName(this.projectName);
        newJoiners.setProjectAllocationDate(this.projectAllocationDate);
        newJoiners.setStatus(this.status);
        return newJoiners;
    }

}
