package com.oneacademy.facultyservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssignedSubjectsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String subjectCode;
    @ManyToOne(optional = false)
    @JoinColumn(name = "ingress_faculty_entity_id", nullable = false)
    private IngressFacultyEntity ingressFaculty;
}
