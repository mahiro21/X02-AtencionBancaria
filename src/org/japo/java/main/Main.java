/* 
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Mario Merlos Abella <mario.merlos.alum@iescamp.es>
 */
public final class Main {

    //Objeto random
    public static final Random RND = new Random();

    //Objeto scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH);

    public static void main(String[] args) {
        //Limite dia
        final int H_MIN = 0;
        final int H_MAX = 23;
        final int M_MIN = 0;
        final int M_MAX = 59;
        final int TMP_MIN = 0;
        final int TMP_MAX = H_MAX * 60 + M_MAX;

        //Atencio bancaria
        final int H_INI = 10;
        final int H_FIN = 12;
        final int M_INI = 30;
        final int M_FIN = 15;
        final int TMP_INI = H_INI * 60 + M_INI;
        final int TMP_FIN = H_FIN * 60 + M_FIN;

        //Hora aleatoria
        int HoraRND = RND.nextInt((H_MAX - H_MIN - 1) - H_MIN);
        int MinutRND = RND.nextInt((M_MAX - M_MIN - 1) - M_MIN);
        int TMP_RND;

        //Hora de usuario
        int HoraUser;
        int MinutUser;
        int TMP_User;

        try {
            //Input user
            //Hora Consola
            System.out.printf("Hora actual ....:");
            HoraUser = SCN.nextInt();

            //Minuto consola
            System.out.printf("Minuto actual ....:");
            MinutUser = SCN.nextInt();

            System.out.printf("=================================================%n");

            //Tiempo user & random
            //Previsualización Hora de usuario y random
            System.out.printf("Hora actual proporcionada ....: %02d:%02d%n", HoraUser, MinutUser);
            System.out.printf("Hora actual random ....: %02d:%02d%n", HoraRND, MinutRND);

            TMP_User = HoraUser * 60 + MinutUser;
            TMP_RND = HoraRND * 60 + MinutRND;

            System.out.printf("=================================================%n");
            
            //Resultado
            String TimeConsol;
            TimeConsol = (TMP_User >= TMP_INI && TMP_User <= TMP_FIN) ? "Horario correcto" : "Horario incorrecto";
                
            String TimeRandom;
            TimeRandom = (TMP_RND >= TMP_INI && TMP_RND <= TMP_FIN) ? "Horario correcto" : "Horario incorrecto";
            
            System.out.printf("Tiempo incorporado por consola ....:%s%n", TimeConsol);
            System.out.printf("Tiempo Aleatorio ....:%s%n", TimeRandom);

        } catch (Exception e) {
            //Mensaje
            System.out.printf("ERROR: Entrada incorrecta");
        } finally {

            //Borrar buffer
            SCN.nextLine();
        }

    }
}
