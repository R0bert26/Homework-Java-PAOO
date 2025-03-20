package com.homework.edunote.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework.edunote.domain.validation.ValidationGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateRequestDto {

    @NotNull
    private UUID id;

    @NotBlank(groups = ValidationGroups.OnPutStudent.class, message = "First name is required")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(groups = ValidationGroups.OnPutStudent.class, message = "Last name is required")
    @JsonProperty("last_name")
    private String lastName;
}
