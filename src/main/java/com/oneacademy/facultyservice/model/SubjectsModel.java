package com.oneacademy.facultyservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectsModel {

    @NotBlank(message = "Required Field")
    private String subjectName;
    @NotBlank(message = "Required Field")
    private String subjectCode;
}
