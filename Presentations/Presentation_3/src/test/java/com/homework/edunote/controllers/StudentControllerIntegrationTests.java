package com.homework.edunote.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.edunote.domain.dtos.StudentCreateRequestDto;
import com.homework.edunote.domain.dtos.StudentUpdateRequestDto;
import com.homework.edunote.domain.entities.StudentEntity;
import com.homework.edunote.services.StudentService;
import com.homework.edunote.utils.TestDataUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class StudentControllerIntegrationTests {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final StudentService studentService;

    @Autowired
    public StudentControllerIntegrationTests(
            MockMvc mockMvc,
            ObjectMapper objectMapper,
            StudentService studentService) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.studentService = studentService;
    }

    @Test
    void testThatCreateStudentReturnsSavedStudentAndHttp201CreatedWhenRequestIsValid() throws Exception {
        StudentCreateRequestDto student = TestDataUtil.createStudentCreateRequestDto();
        String requestJson = objectMapper.writeValueAsString(student);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").exists()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.first_name").value(student.getFirstName())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.last_name").value(student.getLastName())
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    void testThatCreateStudentReturnsHttp400BadRequestWhenRequestIsInvalid() throws Exception {
        StudentCreateRequestDto student = TestDataUtil.createStudentCreateRequestDto();
        student.setFirstName(null);
        String requestJson = objectMapper.writeValueAsString(student);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    void testThatGetStudentByIdReturnsSavedStudentAndHttp200OkWhenStudentExists() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/students/" + savedStudent.getId())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").value(savedStudent.getId().toString())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.first_name").value(savedStudent.getFirstName())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.last_name").value(savedStudent.getLastName())
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void testThatGetStudentByIdReturnsHttp404NotFoundWhenStudentDoesNotExist() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/students/" + id)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.status").value(404)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.message")
                        .value("Student with id " + id + " not found.")
        );
    }

    @Test
    void testThatGetAllStudentsReturnsListOfSavedStudentsAndHttp200Ok() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/students")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").value(savedStudent.getId().toString())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].first_name").value(savedStudent.getFirstName())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].last_name").value(savedStudent.getLastName())
        );
    }

    @Test
    void testThatPartialUpdateStudentReturnsUpdatedStudentAndHttp200Ok() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        StudentUpdateRequestDto studentUpdateRequestDto = TestDataUtil.createStudentUpdateRequestDto(savedStudent.getId());
        studentUpdateRequestDto.setFirstName("Test");
        studentUpdateRequestDto.setLastName(null);
        String requestJson = objectMapper.writeValueAsString(studentUpdateRequestDto);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/students/" + studentUpdateRequestDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").value(studentUpdateRequestDto.getId().toString())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.first_name").value(studentUpdateRequestDto.getFirstName())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.last_name").value(savedStudent.getLastName())
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void testThatFullUpdateStudentReturnsUpdatedStudentAndHttp200Ok() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        StudentUpdateRequestDto studentUpdateRequestDto = TestDataUtil.createStudentUpdateRequestDto(savedStudent.getId());
        studentUpdateRequestDto.setFirstName("Test");
        studentUpdateRequestDto.setLastName("Test");
        String requestJson = objectMapper.writeValueAsString(studentUpdateRequestDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/students/" + studentUpdateRequestDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").value(studentUpdateRequestDto.getId().toString())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.first_name").value(studentUpdateRequestDto.getFirstName())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.last_name").value(studentUpdateRequestDto.getLastName())
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void testThatFullUpdateStudentReturnsHttp400BadRequestWhenRequestIsInvalid() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        StudentUpdateRequestDto studentUpdateRequestDto = TestDataUtil.createStudentUpdateRequestDto(savedStudent.getId());
        studentUpdateRequestDto.setFirstName(null);
        String requestJson = objectMapper.writeValueAsString(studentUpdateRequestDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/students/" + studentUpdateRequestDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.status").value(400)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.message").value(Matchers.containsString("Invalid data:"))
        );
    }

    @Test
    void testThatDeleteStudentReturnsHttp204NoContentWhenStudentExists() throws Exception {
        StudentEntity student = TestDataUtil.createStudentEntity();
        StudentEntity savedStudent = studentService.createStudent(student);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/students/" + savedStudent.getId())
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent()
        );
    }

    @Test
    void testThatDeleteStudentReturnsHttp404NotFoundWhenStudentDoesNotExist() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/students/" + id)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.status").value(404)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.message")
                        .value("Student with id " + id + " not found.")
        );
    }
}
