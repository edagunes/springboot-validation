package net.javaguides.springboot.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TaxValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Documented
public @interface TaxValidation {

	String message() default "{TaxValidation.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
