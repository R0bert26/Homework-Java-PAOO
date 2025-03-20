package com.homework.edunote.services;

import com.homework.edunote.domain.entities.StudentEntity;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentEntity createStudent(StudentEntity studentEntity);
    List<StudentEntity> getAllStudents();
    StudentEntity getStudentById(UUID id);
    void deleteStudentById(UUID id);
    StudentEntity partialUpdateStudentById(UUID id, StudentEntity student);
    StudentEntity fullUpdateStudentById(UUID id, StudentEntity student);
}
