package com.homework.edunote.mappers;

import com.homework.edunote.domains.dtos.StudentCreateRequestDto;
import com.homework.edunote.domains.dtos.StudentResponseDto;
import com.homework.edunote.domains.entities.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentEntity mapFromStudentCreateRequestDtoToStudentEntity(
            StudentCreateRequestDto studentCreateRequestDto) {
        return modelMapper.map(studentCreateRequestDto, StudentEntity.class);
    }

    public StudentResponseDto mapFromStudentEntityToStudentResponseDto(
            StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentResponseDto.class);
    }
}
