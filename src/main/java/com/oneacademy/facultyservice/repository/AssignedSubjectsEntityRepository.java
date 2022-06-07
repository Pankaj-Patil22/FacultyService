package com.oneacademy.facultyservice.repository;

import com.oneacademy.facultyservice.entity.AssignedSubjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedSubjectsEntityRepository extends JpaRepository<AssignedSubjectsEntity, Long> {
}