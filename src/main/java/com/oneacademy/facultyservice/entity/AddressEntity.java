package com.oneacademy.facultyservice.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String houseNumber;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String pinCode;
    @Column(nullable = false)
    private String type;
    @ManyToOne(optional = false)
    @JoinColumn(name = "ingress_faculty_entity_id", nullable = false)
    private IngressFacultyEntity ingressFaculty;
}
