package com.oneacademy.facultyservice.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class IngressFacultyModel {

    @NotBlank(message = "Required Field")
    private String firstName;
    @NotBlank(message = "Required Field")
    private String lastName;
    @NotBlank(message = "Required Field")
    @Email(message = "Invalid email id", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;
    @NotBlank(message = "Required Field")
    private String contactNumber;
    @NotBlank(message = "Required Field")
    private List<AddressModel> addressModel=new ArrayList<>();
    @NotBlank(message = "Required Field")
    private String department;
    @NotBlank(message = "Required Field")
    private String designation;
    @NotBlank(message = "Required Field")
    private String status;
    @NotBlank(message = "Required Field")
    private String highestQualification;
    @NotBlank(message = "Required Field")
    private String studiedAt;
    @NotBlank(message = "Required Field")
    private List<AssignedSubjectsModel> assignedSubjectsModel =new ArrayList<>();
}
