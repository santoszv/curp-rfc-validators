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

package mx.com.inftel.contraints.rfc.validators;

import mx.com.inftel.contraints.rfc.RFC;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Normalizer;
import java.util.Locale;

public class DigitoVerificadorValidator implements ConstraintValidator<RFC.DigitoVerificador, String> {

    private static final String VALORES = "0123456789ABCDEFGHIJKLMN&OPQRSTUVWXYZ \u00D1";

    public void initialize(RFC.DigitoVerificador constraintAnnotation) {
        // NO-OP
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        value = Normalizer.normalize(value, Normalizer.Form.NFC).toUpperCase(Locale.ENGLISH);

        if (value.length() == 12) {
            value = " " + value;
        }
        if (value.length() != 13) {
            return false;
        }

        int resultado = 0;
        for (int i = 0; i < 12; i++) {
            int valor = VALORES.indexOf(value.charAt(11 - i));
            resultado += valor * (i + 2);
        }
        resultado = resultado % 11;
        String digito;
        if (resultado == 0) {
            digito = "0";
        } else if (resultado == 10) {
            digito = "A";
        } else {
            digito = String.valueOf(11 - resultado);
        }

        return value.endsWith(digito);
    }
}
