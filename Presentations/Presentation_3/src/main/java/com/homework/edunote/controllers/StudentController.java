package com.homework.edunote.controllers;

import com.homework.edunote.domain.dtos.StudentCreateRequestDto;
import com.homework.edunote.domain.dtos.StudentResponseDto;
import com.homework.edunote.domain.dtos.StudentUpdateRequestDto;
import com.homework.edunote.domain.entities.StudentEntity;
import com.homework.edunote.domain.validation.ValidationGroups;
import com.homework.edunote.mappers.StudentMapper;
import com.homework.edunote.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(
            @Validated @RequestBody StudentCreateRequestDto studentCreateRequestDto) {
        StudentEntity studentToCreate = studentMapper.mapFromStudentCreateRequestDtoToStudentEntity(studentCreateRequestDto);
        StudentEntity savedStudent = studentService.createStudent(studentToCreate);
        StudentResponseDto savedStudentDto = studentMapper.mapFromStudentEntityToStudentResponseDto(savedStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        List<StudentEntity> students = studentService.getAllStudents();
        List<StudentResponseDto> studentsDto = students.stream()
                .map(studentMapper::mapFromStudentEntityToStudentResponseDto)
                .toList();

        return ResponseEntity.ok(studentsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable UUID id) {
        StudentEntity student = studentService.getStudentById(id);
        StudentResponseDto studentDto = studentMapper.mapFromStudentEntityToStudentResponseDto(student);

        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable UUID id) {
        studentService.deleteStudentById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDto> partialUpdateStudentById(
            @PathVariable UUID id,
            @Validated(ValidationGroups.OnPatchStudent.class) @RequestBody StudentUpdateRequestDto studentUpdateRequestDto) {

        StudentEntity student = studentMapper.mapFromStudentUpdateRequestDtoToStudentEntity(studentUpdateRequestDto);
        StudentEntity updatedStudent = studentService.partialUpdateStudentById(id, student);
        StudentResponseDto updatedStudentDto = studentMapper.mapFromStudentEntityToStudentResponseDto(updatedStudent);

        return ResponseEntity.ok(updatedStudentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> fullUpdateStudentById(
            @PathVariable UUID id,
            @Validated(ValidationGroups.OnPutStudent.class) @RequestBody StudentUpdateRequestDto studentUpdateRequestDto) {

        StudentEntity student = studentMapper.mapFromStudentUpdateRequestDtoToStudentEntity(studentUpdateRequestDto);
        StudentEntity updatedStudent = studentService.fullUpdateStudentById(id, student);
        StudentResponseDto updatedStudentDto = studentMapper.mapFromStudentEntityToStudentResponseDto(updatedStudent);

        return ResponseEntity.ok(updatedStudentDto);
    }
}
