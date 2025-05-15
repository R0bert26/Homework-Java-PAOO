package com.homeworks.homeworkjava32.controllers;

import com.homeworks.homeworkjava32.domain.dtos.SolutionDto;
import com.homeworks.homeworkjava32.services.EquationResolverService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EquationController {
    EquationResolverService equationResolverService;

    @GetMapping("/equation")
    public ResponseEntity<SolutionDto> resolveEquation(@RequestParam float a, @RequestParam float b) {
        SolutionDto solutionDto = equationResolverService.resolveGrade1Equation(a, b);
        return ResponseEntity.ok(solutionDto);
    }
}
