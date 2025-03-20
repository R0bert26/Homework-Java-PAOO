package com.homework.edunote.mappers.impl;

import com.homework.edunote.domain.dtos.StudentCreateRequestDto;
import com.homework.edunote.domain.dtos.StudentResponseDto;
import com.homework.edunote.domain.dtos.StudentUpdateRequestDto;
import com.homework.edunote.domain.entities.StudentEntity;
import com.homework.edunote.mappers.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapperImpl implements StudentMapper {

    private final ModelMapper modelMapper;

    public StudentEntity mapFromStudentCreateRequestDtoToStudentEntity(
            StudentCreateRequestDto studentCreateRequestDto) {
        return modelMapper.map(studentCreateRequestDto, StudentEntity.class);
    }

    public StudentResponseDto mapFromStudentEntityToStudentResponseDto(
            StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentResponseDto.class);
    }

    @Override
    public StudentEntity mapFromStudentUpdateRequestDtoToStudentEntity(StudentUpdateRequestDto studentUpdateRequestDto) {
        return modelMapper.map(studentUpdateRequestDto, StudentEntity.class);
    }
}
