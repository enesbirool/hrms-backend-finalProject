package kodlamaio_birol.hrms.core.utilities;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {
    String message() default "Email Must be Unique";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
