package com.homework.edunote.services.impl;

import com.homework.edunote.domains.entities.StudentEntity;
import com.homework.edunote.exceptions.StudentNotFoundException;
import com.homework.edunote.repositories.StudentRepository;
import com.homework.edunote.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    @Transactional
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public StudentEntity getStudentById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found."));
    }

    @Override
    @Transactional
    public void deleteStudentById(UUID id) {
        StudentEntity savedStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found."));

        studentRepository.delete(savedStudent);
    }
}
