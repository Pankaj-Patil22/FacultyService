package com.oneacademy.facultyservice.repository;

import com.oneacademy.facultyservice.entity.SubjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsEntityRepository extends JpaRepository<SubjectsEntity, Long> {
    boolean existsBySubjectCode(String subjectCode);
}