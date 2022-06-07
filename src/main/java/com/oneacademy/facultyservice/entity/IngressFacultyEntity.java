package com.oneacademy.facultyservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class IngressFacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String contactNumber;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "ingressFaculty", orphanRemoval = true)
    private List<AddressEntity> addressEntity= new ArrayList<>();
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String designation;
    @Column(nullable = false)
    private String status;//permanent,contract etc
    @Column(nullable = false)
    private String highestQualification;
    @Column(nullable = false)
    private String studiedAt;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ingressFaculty", orphanRemoval = true)
    private List<AssignedSubjectsEntity> assignedSubjectsEntity = new ArrayList<>();


    public void addAddress(AddressEntity address)
    {
        if(address!=null)
        {
            if(addressEntity==null)
            {
                addressEntity=new ArrayList<>();
            }
            address.setIngressFaculty(this);
            addressEntity.add(address);
        }
    }

    public void addAssignedSubject(AssignedSubjectsEntity subjects)
    {
        if(subjects!=null)
        {
            if(assignedSubjectsEntity ==null)
            {
                assignedSubjectsEntity =new ArrayList<>();
            }
            subjects.setIngressFaculty(this);
            assignedSubjectsEntity.add(subjects);
        }
    }
}
