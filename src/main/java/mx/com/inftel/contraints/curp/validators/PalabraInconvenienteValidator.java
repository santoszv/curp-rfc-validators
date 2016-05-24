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

package mx.com.inftel.contraints.curp.validators;

import mx.com.inftel.contraints.curp.CURP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.Normalizer;
import java.util.Locale;

public class PalabraInconvenienteValidator implements ConstraintValidator<CURP.PalabraInconveniente, String> {

    private static final String[] PALABRAS = new String[]{
            "BACA", "BAKA",
            "BUEI", "BUEY",
            "CACA", "CACO", "CAGA", "CAGO", "CAKA", "CAKO",
            "COGE", "COGI", "COJA", "COJE", "COJI", "COJO", "COLA",
            "CULO",
            "FALO",
            "FETO",
            "GETA",
            "GUEI", "GUEY",
            "JOTO",
            "KACA", "KACO", "KAGA", "KAGO", "KAKA", "KAKO",
            "KOGE", "KOGI", "KOJA", "KOJE", "KOJI", "KOJO",
            "KOLA",
            "KULO",
            "LILO",
            "LOCA", "LOCO", "LOKA", "LOKO",
            "MAME", "MAMO",
            "MEAR", "MEAS", "MEON",
            "MIAR", "MION",
            "MOCO", "MOKO",
            "MULA", "MULO",
            "NACA", "NACO",
            "PEDA", "PEDO", "PENE",
            "PIPI", "PITO",
            "POPO",
            "PUTA", "PUTO",
            "QULO",
            "RATA",
            "ROBA", "ROBE", "ROBO",
            "RUIN",
            "SENO",
            "TETA",
            "VACA", "VAGA", "VAGO", "VAKA",
            "VUEI", "VUEY",
            "WUEI", "WUEY"};

    public void initialize(CURP.PalabraInconveniente constraintAnnotation) {
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
