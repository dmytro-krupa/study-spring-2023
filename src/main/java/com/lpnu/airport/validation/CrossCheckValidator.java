package com.lpnu.airport.validation;


import com.lpnu.airport.validation.enumeration.Condition;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class CrossCheckValidator implements ConstraintValidator<CrossCheck, Object> {

    private static final SpelExpressionParser PARSER = new SpelExpressionParser();

    private String field1;
    private String field2;
    private Condition condition;



    @Override
    public void initialize(final CrossCheck constraintAnnotation) {
        field1 = constraintAnnotation.field1();
        field2 = constraintAnnotation.field2();
        condition = constraintAnnotation.condition();
    }


    //що тут є value
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
            return (Boolean) PARSER.parseExpression(
                    field1 + " " + condition.getCondition() + " " + field2
        ).getValue(value);

    }
}