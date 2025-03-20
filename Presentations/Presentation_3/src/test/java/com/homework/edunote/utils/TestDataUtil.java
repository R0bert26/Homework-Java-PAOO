package com.homework.edunote.utils;

import com.homework.edunote.domain.dtos.StudentCreateRequestDto;
import com.homework.edunote.domain.dtos.StudentUpdateRequestDto;
import com.homework.edunote.domain.entities.StudentEntity;

import java.util.UUID;

public final class TestDataUtil {

    private TestDataUtil() {}

    public static StudentCreateRequestDto createStudentCreateRequestDto() {
        return StudentCreateRequestDto.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
    }

    public static StudentUpdateRequestDto createStudentUpdateRequestDto(UUID id) {
        return StudentUpdateRequestDto.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .build();
    }

    public static StudentEntity createStudentEntity() {
        return StudentEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
    }
}
