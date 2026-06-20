package util;

/**
 * Excepción personalizada utilizada cuando los datos
 * de una persona no cumplen las reglas del sistema.
 */
public class PersonaInvalidaException extends IllegalArgumentException {

    /**
     * Construye una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del dato inválido
     */
    public PersonaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
