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

package mx.com.inftel.contraints.rfc.validators;

import mx.com.inftel.contraints.rfc.RFC;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Normalizer;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class RFCValidator implements ConstraintValidator<RFC, String> {

    private Pattern pattern;
    private boolean isNullValueValid;
    private boolean isEmptyValueValid;
    private boolean isXAXX010101000ValueValid;
    private boolean isXEXX010101000ValueValid;

    public void initialize(RFC constraintAnnotation) {
        pattern = Pattern.compile("[&A-Z\u00D1]{3,4}[0-9]{6}[1-9A-Z]{2}[0-9A]{1}",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);
        isNullValueValid = constraintAnnotation.isNullValueValid();
        isEmptyValueValid = constraintAnnotation.isEmptyValueValid();
        isXAXX010101000ValueValid = constraintAnnotation.isXAXX010101000ValueValid();
        isXEXX010101000ValueValid = constraintAnnotation.isXEXX010101000ValueValid();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return isNullValueValid;
        }

        if (value.isEmpty()) {
            return isEmptyValueValid;
        }

        value = Normalizer.normalize(value, Normalizer.Form.NFC).toUpperCase(Locale.ENGLISH);

        if (value.equals("XAXX010101000")) {
            return isXAXX010101000ValueValid;
        }

        if (value.equals("XEXX010101000")) {
            return isXEXX010101000ValueValid;
        }

        return pattern.matcher(value).matches();
    }
}
