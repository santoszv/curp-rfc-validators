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

package mx.com.inftel.validators.rfc;

import mx.com.inftel.validators.rfc.validators.DigitoVerificadorValidator;
import mx.com.inftel.validators.rfc.validators.PalabraInconvenienteValidator;
import mx.com.inftel.validators.rfc.validators.RFCValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RFCValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RFC {

    boolean isNullValueValid() default true;

    boolean isEmptyValueValid() default false;

    boolean isXAXX010101000ValueValid() default false;

    boolean isXEXX010101000ValueValid() default false;

    String message() default "{mx.com.inftel.validators.rfc.RFC.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        RFC[] value();
    }

    @Documented
    @Constraint(validatedBy = PalabraInconvenienteValidator.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface PalabraInconveniente {

        String message() default "{mx.com.inftel.validators.rfc.RFC.PalabraInconveniente.message}";

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

        String message() default "{mx.com.inftel.validators.rfc.RFC.DigitoVerificador.message}";

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
