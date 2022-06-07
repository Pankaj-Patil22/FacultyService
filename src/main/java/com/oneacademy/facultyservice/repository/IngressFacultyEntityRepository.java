package com.oneacademy.facultyservice.repository;

import com.oneacademy.facultyservice.entity.IngressFacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngressFacultyEntityRepository extends JpaRepository<IngressFacultyEntity, Long> {
    boolean existsByEmailIgnoreCase(String email);
}