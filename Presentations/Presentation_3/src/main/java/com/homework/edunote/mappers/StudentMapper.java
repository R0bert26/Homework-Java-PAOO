package com.homework.edunote.mappers;

import com.homework.edunote.domain.dtos.StudentCreateRequestDto;
import com.homework.edunote.domain.dtos.StudentResponseDto;
import com.homework.edunote.domain.dtos.StudentUpdateRequestDto;
import com.homework.edunote.domain.entities.StudentEntity;

public interface StudentMapper {

    StudentEntity mapFromStudentCreateRequestDtoToStudentEntity(StudentCreateRequestDto studentCreateRequestDto);
    StudentResponseDto mapFromStudentEntityToStudentResponseDto(StudentEntity studentEntity);
    StudentEntity mapFromStudentUpdateRequestDtoToStudentEntity(StudentUpdateRequestDto studentUpdateRequestDto);
}
