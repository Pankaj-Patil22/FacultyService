package com.oneacademy.facultyservice.services;

import com.oneacademy.facultyservice.entity.IngressFacultyEntity;
import com.oneacademy.facultyservice.entity.SubjectsEntity;
import com.oneacademy.facultyservice.model.IngressFacultyModel;
import com.oneacademy.facultyservice.model.SubjectsModel;

public interface FacultyService {

    IngressFacultyEntity ingressFaculty(IngressFacultyModel facultyModel);

    SubjectsEntity newSubject(SubjectsModel subjectsModel);
}
