package com.oneacademy.facultyservice.services;

import com.oneacademy.facultyservice.entity.AddressEntity;
import com.oneacademy.facultyservice.entity.AssignedSubjectsEntity;
import com.oneacademy.facultyservice.entity.IngressFacultyEntity;
import com.oneacademy.facultyservice.entity.SubjectsEntity;
import com.oneacademy.facultyservice.model.IngressFacultyModel;
import com.oneacademy.facultyservice.model.SubjectsModel;
import com.oneacademy.facultyservice.repository.AssignedSubjectsEntityRepository;
import com.oneacademy.facultyservice.repository.IngressFacultyEntityRepository;
import com.oneacademy.facultyservice.repository.SubjectsEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private IngressFacultyEntityRepository ingressFacultyEntityRepository;
    @Autowired
    private SubjectsEntityRepository subjectsEntityRepository;
    @Autowired
    private AssignedSubjectsEntityRepository assignedSubjectsEntityRepository;

    @Override
    public IngressFacultyEntity ingressFaculty(IngressFacultyModel facultyModel) {
        if (ingressFacultyEntityRepository.existsByEmailIgnoreCase(facultyModel.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        for (int i = 0; i < facultyModel.getAssignedSubjectsModel().size(); i++) {
            if (!subjectsEntityRepository.existsBySubjectCode(facultyModel.getAssignedSubjectsModel().get(i).getSubjectCode())) {
                throw new IllegalArgumentException("No subject found: " + facultyModel.getAssignedSubjectsModel().get(i).getSubjectCode());
            }
        }


        IngressFacultyEntity ingressFacultyEntity = IngressFacultyEntity.builder()
                .firstName(facultyModel.getFirstName())
                .lastName(facultyModel.getLastName())
                .email(facultyModel.getEmail())
                .contactNumber(facultyModel.getContactNumber())
                .department(facultyModel.getDepartment())
                .designation(facultyModel.getDesignation())
                .status(facultyModel.getStatus())
                .highestQualification(facultyModel.getHighestQualification())
                .studiedAt(facultyModel.getStudiedAt())
                .build();

        AddressEntity addressEntity1 = new AddressEntity();
        AddressEntity addressEntity2 = new AddressEntity();
        BeanUtils.copyProperties(facultyModel.getAddressModel().get(0), addressEntity1);
        BeanUtils.copyProperties(facultyModel.getAddressModel().get(1), addressEntity2);


        for (AddressEntity addressEntity : Arrays.asList(addressEntity1, addressEntity2)) {
            ingressFacultyEntity.addAddress(addressEntity);
        }

        for (int i = 0; i < facultyModel.getAssignedSubjectsModel().size(); i++) {
            AssignedSubjectsEntity assignedSubjectsEntity = new AssignedSubjectsEntity();
            BeanUtils.copyProperties(facultyModel.getAssignedSubjectsModel().get(i), assignedSubjectsEntity);
            ingressFacultyEntity.addAssignedSubject(assignedSubjectsEntity);
        }

        ingressFacultyEntityRepository.save(ingressFacultyEntity);

        return ingressFacultyEntity;
    }

    @Override
    public SubjectsEntity newSubject(SubjectsModel subjectsModel) {
        if (subjectsEntityRepository.existsBySubjectCode(subjectsModel.getSubjectCode())) {
            throw new IllegalArgumentException("Subject already present");
        }

        SubjectsEntity subjectsEntity = SubjectsEntity.builder()
                .subjectName(subjectsModel.getSubjectName())
                .subjectCode(subjectsModel.getSubjectCode())
                .build();

        subjectsEntityRepository.save(subjectsEntity);

        return subjectsEntity;
    }

}
