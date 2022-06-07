package com.oneacademy.facultyservice.controller;

import com.oneacademy.facultyservice.entity.IngressFacultyEntity;
import com.oneacademy.facultyservice.entity.SubjectsEntity;
import com.oneacademy.facultyservice.model.IngressFacultyModel;
import com.oneacademy.facultyservice.model.SubjectsModel;
import com.oneacademy.facultyservice.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/new-subject")
    public String newSubject(@RequestBody SubjectsModel subjectsModel)
    {
        try{
            SubjectsEntity subjectsEntity=facultyService.newSubject(subjectsModel);
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }

        return "Success";
    }

    @PostMapping("/ingress-faculty")
    public String ingressFaculty(@RequestBody IngressFacultyModel facultyModel)
    {
        try{
            IngressFacultyEntity ingressFacultyEntity=facultyService.ingressFaculty(facultyModel);
        }
        catch (Exception e){
            return e.getLocalizedMessage();
        }

        return "Success";
    }
}
