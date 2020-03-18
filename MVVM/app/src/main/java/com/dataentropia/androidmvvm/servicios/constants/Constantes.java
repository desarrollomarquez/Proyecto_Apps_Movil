package com.dataentropia.androidmvvm.servicios.constants;

import java.util.HashMap;
import java.util.Map;

public class Constantes {

    /*
     * Enumerados para el tipo validacion OTP en base de datos
     */
    public enum EstadoValidacionOtp {
        NoExiste(0), Existe(1), OtpVencido(2);

        private final int value;

        private EstadoValidacionOtp(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private static Map map = new HashMap<>();

        static {
            for (EstadoValidacionOtp pageType : EstadoValidacionOtp.values()) {
                map.put(pageType.value, pageType);
            }
        }

        public static EstadoValidacionOtp valueOf(int pageType) {
            return (EstadoValidacionOtp) map.get(pageType);
        }
    }


    /*
     * Enumerados para el tipo de estado de un usuario en base de datos.
     */
    public enum EstadoConsultaUsuario {
        NoExiste(0), Existe(1), Existe_SinCorreo(2), Existe_ConCorreo(3), Existe_ConUsuarioTransaccional(4),
        ClaveIncorrecta(5), UsuarioBloqueado(6), Existe_UsuarioNoMigrado(7), Existe_Migrado(8);

        private final int value;

        private EstadoConsultaUsuario(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
