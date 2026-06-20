package util;

/**
 * Clase encargada de validar los datos de un cargo
 * antes de crear un objeto de tipo Cargo.
 */
public class ValidadorDatosCargo {

    /**
     * Valida los datos correspondientes a un cargo.
     *
     * @param nombreCargo nombre del cargo o función
     * @param organizacion organización donde desempeña el cargo
     * @param comunaCargo comuna donde se desempeña
     * @param tiempoCargo cantidad de años en el cargo
     * @throws CargoInvalidoException si algún dato no es válido
     */
    public static void validarCargo(
            String nombreCargo,
            String organizacion,
            String comunaCargo,
            int tiempoCargo) {

        if (nombreCargo == null || nombreCargo.trim().isEmpty()) {
            throw new CargoInvalidoException(
                    "El nombre del cargo no puede estar vacío."
            );
        }

        if (nombreCargo.trim().length() < 3) {
            throw new CargoInvalidoException(
                    "El nombre del cargo debe tener al menos 3 caracteres."
            );
        }

        if (organizacion == null || organizacion.trim().isEmpty()) {
            throw new CargoInvalidoException(
                    "El nombre de la organización no puede estar vacío."
            );
        }

        if (organizacion.trim().length() < 3) {
            throw new CargoInvalidoException(
                    "El nombre de la organización debe tener al menos 3 caracteres."
            );
        }

        if (comunaCargo == null || comunaCargo.trim().isEmpty()) {
            throw new CargoInvalidoException(
                    "La comuna del cargo no puede estar vacía."
            );
        }

        if (comunaCargo.trim().length() < 3) {
            throw new CargoInvalidoException(
                    "La comuna debe tener al menos 3 caracteres."
            );
        }

        if (tiempoCargo < 0) {
            throw new CargoInvalidoException(
                    "El tiempo en el cargo no puede ser negativo."
            );
        }

        if (tiempoCargo > 60) {
            throw new CargoInvalidoException(
                    "El tiempo en el cargo no puede superar los 60 años."
            );
        }
    }
}
