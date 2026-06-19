package util;

/**
 * Excepción personalizada utilizada cuando los datos
 * de un cargo no cumplen las reglas del sistema.
 */
public class CargoInvalidoException extends IllegalArgumentException {

    /**
     * Construye una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del dato inválido
     */
    public CargoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
