/*
 *    Copyright 2013-2016 Santos Zatarain Vera
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

package mx.com.inftel.contraints.curp;

import mx.com.inftel.contraints.curp.validators.CURPValidator;
import mx.com.inftel.contraints.curp.validators.DigitoVerificadorValidator;
import mx.com.inftel.contraints.curp.validators.PalabraInconvenienteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint for validating a well-formed CURP.
 */
@Documented
@Constraint(validatedBy = CURPValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CURP {

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
     * Standard message template.
     *
     * @return Default message template string.
     */
    String message() default "{mx.com.inftel.contraints.curp.CURP.message}";

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
         * Multiple {@code CURP} specification.
         *
         * @return Empty array by default.
         */
        CURP[] value();
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
        String message() default "{mx.com.inftel.contraints.curp.CURP.PalabraInconveniente.message}";

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
             * Multiple {@code PalabraInconveniente} specification.
             *
             * @return Empty array by default.
             */
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
        String message() default "{mx.com.inftel.contraints.curp.CURP.DigitoVerificador.message}";

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

            /**
             * Multiple {@code DigitoVerificador} specification.
             *
             * @return Empty array by default.
             */
            DigitoVerificador[] value();
        }
    }
}
