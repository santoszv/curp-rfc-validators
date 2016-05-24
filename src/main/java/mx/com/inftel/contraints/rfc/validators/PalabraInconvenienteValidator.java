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

public class PalabraInconvenienteValidator implements ConstraintValidator<RFC.PalabraInconveniente, String> {

    private static final String[] PALABRAS = new String[]{
            "BUEI", "BUEY",
            "CACA", "CACO", "CAGA", "CAGO", "CAKA",
            "COGE", "COJA", "COJE", "COJI", "COJO",
            "CULO",
            "FETO",
            "GUEY",
            "JOTO",
            "KACA", "KACO", "KAGA", "KAGO", "KAKA",
            "KOGE", "KOJO",
            "KULO",
            "MAME", "MAMO",
            "MEAR", "MEON",
            "MION",
            "MOCO",
            "MULA",
            "PEDA", "PEDO", "PENE",
            "PUTA", "PUTO",
            "QULO",
            "RATA",
            "RUIN"};

    public void initialize(RFC.PalabraInconveniente constraintAnnotation) {
        // NO-OP
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        value = Normalizer.normalize(value, Normalizer.Form.NFC).toUpperCase(Locale.ENGLISH);

        for (String palabra : PALABRAS) {
            if (value.startsWith(palabra)) {
                return false;
            }
        }

        return true;
    }
}
