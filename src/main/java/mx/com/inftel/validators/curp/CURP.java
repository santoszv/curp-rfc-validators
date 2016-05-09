/*
 *    Copyright 2016 Santos Zatarain Vera
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package mx.com.inftel.validators.curp;

import mx.com.inftel.validators.curp.validators.CURPValidator;
import mx.com.inftel.validators.curp.validators.DigitoVerificadorValidator;
import mx.com.inftel.validators.curp.validators.PalabraInconvenienteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CURPValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CURP {

    boolean isNullValueValid() default true;

    boolean isEmptyValueValid() default false;

    String message() default "{mx.com.inftel.validators.curp.CURP.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        CURP[] value();
    }

    @Documented
    @Constraint(validatedBy = PalabraInconvenienteValidator.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface PalabraInconveniente {

        String message() default "{mx.com.inftel.validators.curp.CURP.PalabraInconveniente.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

        @Documented
        @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
                ElementType.CONSTRUCTOR, ElementType.PARAMETER})
        @Retention(RetentionPolicy.RUNTIME)
        @interface List {
            PalabraInconveniente[] value();
        }
    }

    @Documented
    @Constraint(validatedBy = DigitoVerificadorValidator.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface DigitoVerificador {

        String message() default "{mx.com.inftel.validators.curp.CURP.DigitoVerificador.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

        @Documented
        @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
                ElementType.CONSTRUCTOR, ElementType.PARAMETER})
        @Retention(RetentionPolicy.RUNTIME)
        @interface List {
            PalabraInconveniente[] value();
        }
    }
}
