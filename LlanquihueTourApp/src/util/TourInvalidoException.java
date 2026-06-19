package util;

/**
 * Excepción personalizada utilizada cuando los datos
 * de un tour no cumplen las reglas del sistema.
 */
public class TourInvalidoException extends IllegalArgumentException {

    /**
     * Construye una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del dato inválido
     */
    public TourInvalidoException(String mensaje) {
        super(mensaje);
    }
}
