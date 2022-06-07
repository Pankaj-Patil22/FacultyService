package com.oneacademy.facultyservice.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddressModel {

    private String houseNumber;
    @NotBlank(message = "Required Field")
    private String street;
    @NotBlank(message = "Required Field")
    private String city;
    @NotBlank(message = "Required Field")
    private String state;
    @NotBlank(message = "Required Field")
    private String country;
    @NotBlank(message = "Required Field")
    private String pinCode;
    @NotBlank(message = "Required Field")
    private String type;//permanent or temp
}
