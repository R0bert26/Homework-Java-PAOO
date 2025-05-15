package com.homeworks.homeworkjava32.services.impl;

import com.homeworks.homeworkjava32.domain.dtos.SolutionDto;
import com.homeworks.homeworkjava32.exceptions.InfiniteSolutionException;
import com.homeworks.homeworkjava32.exceptions.NoSolutionException;
import com.homeworks.homeworkjava32.services.EquationResolverService;
import org.springframework.stereotype.Service;

@Service
public class EquationResolverServiceImpl implements EquationResolverService {
    public SolutionDto resolveGrade1Equation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                throw new InfiniteSolutionException("Equation has infinite solutions");
            }
            else {
                throw new NoSolutionException("Equation has no solutions");
            }
        }

        return new SolutionDto(-b / a);
    }
}
