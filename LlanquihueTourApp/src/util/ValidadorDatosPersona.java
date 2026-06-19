package util;

/**
 * Clase encargada de validar los datos de una persona
 * antes de crear un objeto de tipo Persona.
 */
public class ValidadorDatosPersona {

    /**
     * Valida los datos principales de una persona.
     *
     * @param nombre nombre de la persona
     * @param relacionEmpresa relación con Llanquihue Tour
     * @throws PersonaInvalidaException si algún dato no es válido
     */
    public static void validarPersona(
            String nombre,
            String relacionEmpresa) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new PersonaInvalidaException(
                    "El nombre no puede estar vacío."
            );
        }

        if (nombre.trim().length() < 3) {
            throw new PersonaInvalidaException(
                    "El nombre debe tener al menos 3 caracteres."
            );
        }

        if (relacionEmpresa == null
                || relacionEmpresa.trim().isEmpty()) {

            throw new PersonaInvalidaException(
                    "La relación con la empresa no puede estar vacía."
            );
        }

        if (!relacionEmpresa.equalsIgnoreCase("empleado")
                && !relacionEmpresa.equalsIgnoreCase("colaborador")
                && !relacionEmpresa.equalsIgnoreCase("proveedor")) {

            throw new PersonaInvalidaException(
                    "La relación debe ser empleado, colaborador o proveedor."
            );
        }
    }
}
