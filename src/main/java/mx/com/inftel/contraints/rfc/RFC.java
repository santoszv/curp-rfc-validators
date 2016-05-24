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

package mx.com.inftel.contraints.rfc;

import mx.com.inftel.contraints.rfc.validators.DigitoVerificadorValidator;
import mx.com.inftel.contraints.rfc.validators.PalabraInconvenienteValidator;
import mx.com.inftel.contraints.rfc.validators.RFCValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint for validating a well-formed RFC.
 */
@Documented
@Constraint(validatedBy = RFCValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RFC {

    /**
     * Determines if {@code null} is a valid value.
     *
     * @return {@code true} by default, {@code null} is a valid value by default.
     */
    boolean isNullValueValid() default true;

    /**
     * Determines if {@code ""} (empty string) is a valid value. Web forms usually send <em>empty fields</em>,
     * this flags is intended for these cases.
     *
     * @return {@code false} by default, empty string is not a valid value by default.
     */
    boolean isEmptyValueValid() default false;

    /**
     * Determines if {@code "XAXX010101000"} (general public's RFC) is a valid value.
     *
     * @return {@code false} by default, general public's RFC is not a valid value by default.
     */
    boolean isXAXX010101000ValueValid() default false;

    /**
     * Determines if {@code "XEXX010101000"} (foreign's RFC) is a valid value.
     *
     * @return {@code false} by default, foreign's RFC is not a valid value by default.
     */
    boolean isXEXX010101000ValueValid() default false;

    /**
     * Standard message template.
     *
     * @return Default message template string.
     */
    String message() default "{mx.com.inftel.contraints.rfc.RFC.message}";

    /**
     * Standard group validation.
     *
     * @return Empty array by default.
     */
    Class<?>[] groups() default {};

    /**
     * Standard payload for this constraint.
     *
     * @return Empty array by default.
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Standard {@code List} sub-element for multiple constraint specification.
     */
    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {

        /**
         * Multiple {@code RFC} specification.
         *
         * @return Empty array by default.
         */
        RFC[] value();
    }

    /**
     * Constraint for validating drawback-words.
     */
    @Documented
    @Constraint(validatedBy = PalabraInconvenienteValidator.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface PalabraInconveniente {

        /**
         * Standard message template.
         *
         * @return Default message template string.
         */
        String message() default "{mx.com.inftel.contraints.rfc.RFC.PalabraInconveniente.message}";

        /**
         * Standard group validation.
         *
         * @return Empty array by default.
         */
        Class<?>[] groups() default {};

        /**
         * Standard payload for this constraint.
         *
         * @return Empty array by default.
         */
        Class<? extends Payload>[] payload() default {};

        /**
         * Standard {@code List} sub-element for multiple constraint specification.
         */
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

        /**
         * Standard message template.
         *
         * @return Default message template string.
         */
        String message() default "{mx.com.inftel.contraints.rfc.RFC.DigitoVerificador.message}";

        /**
         * Standard group validation.
         *
         * @return Empty array by default.
         */
        Class<?>[] groups() default {};

        /**
         * Standard payload for constraint.
         *
         * @return Empty array by default.
         */
        Class<? extends Payload>[] payload() default {};

        /**
         * Standard {@code List} sub-element for multiple constraint specification.
         */
        @Documented
        @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
                ElementType.CONSTRUCTOR, ElementType.PARAMETER})
        @Retention(RetentionPolicy.RUNTIME)
        @interface List {
            DigitoVerificador[] value();
        }
    }
}
