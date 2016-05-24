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

package mx.com.inftel.contraints.curp.validators;

import mx.com.inftel.contraints.curp.CURP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class CURPValidator implements ConstraintValidator<CURP, String> {

    private Pattern pattern;
    private boolean isNullValueValid;
    private boolean isEmptyValueValid;

    public void initialize(CURP constraintAnnotation) {
        pattern = Pattern.compile("[A-Z]{4}[0-9]{6}[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9][0-9]",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);
        isNullValueValid = constraintAnnotation.isNullValueValid();
        isEmptyValueValid = constraintAnnotation.isEmptyValueValid();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return isNullValueValid;
        }

        if (value.isEmpty()) {
            return isEmptyValueValid;
        }

        value = Normalizer.normalize(value, Normalizer.Form.NFC).toUpperCase(Locale.ENGLISH);

        return pattern.matcher(value).matches();
    }
}
