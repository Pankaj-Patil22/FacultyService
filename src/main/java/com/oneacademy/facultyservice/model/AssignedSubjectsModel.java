package com.oneacademy.facultyservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AssignedSubjectsModel {

    @NotBlank(message = "Required Field")
    private String subjectCode;
}
