package com.homework.edunote.services.impl;

import com.homework.edunote.domain.entities.StudentEntity;
import com.homework.edunote.exceptions.StudentNotFoundException;
import com.homework.edunote.repositories.StudentRepository;
import com.homework.edunote.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    @Transactional
    public StudentEntity partialUpdateStudentById(UUID id, StudentEntity student) {
        StudentEntity studentToUpdate = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found."));

        studentToUpdate.setId(id);

        if (student.getFirstName() != null) {
            studentToUpdate.setFirstName(student.getFirstName());
        }

        if (student.getLastName() != null) {
            studentToUpdate.setLastName(student.getLastName());
        }

        return studentRepository.save(studentToUpdate);
    }

    @Override
    public StudentEntity fullUpdateStudentById(UUID id, StudentEntity student) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }

        student.setId(id);

        return studentRepository.save(student);
    }
}
