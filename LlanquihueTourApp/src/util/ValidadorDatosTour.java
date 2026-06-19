package util;

/**
 * Clase encargada de validar los datos de un tour
 * antes de crear un objeto de tipo Tour.
 */
public class ValidadorDatosTour {

    /**
     * Valida los datos correspondientes a un tour.
     *
     * @param nombre nombre del tour
     * @param tipo tipo de tour
     * @param ubicacion lugar donde se realiza el tour
     * @param precioAdulto precio para una persona adulta
     * @throws TourInvalidoException si algún dato no es válido
     */
    public static void validarTour(
            String nombre,
            String tipo,
            String ubicacion,
            int precioAdulto) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new TourInvalidoException(
                    "El nombre del tour no puede estar vacío."
            );
        }

        if (nombre.trim().length() < 3) {
            throw new TourInvalidoException(
                    "El nombre del tour debe tener al menos 3 caracteres."
            );
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new TourInvalidoException(
                    "El tipo de tour no puede estar vacío."
            );
        }

        if (!tipo.equalsIgnoreCase("ruta gastronomica")
                && !tipo.equalsIgnoreCase("paseo lacustre")
                && !tipo.equalsIgnoreCase("excursion cultural")
                && !tipo.equalsIgnoreCase("tour personalizado")) {

            throw new TourInvalidoException(
                    "El tipo de tour no corresponde a una categoría válida."
            );
        }

        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new TourInvalidoException(
                    "La ubicación del tour no puede estar vacía."
            );
        }

        if (ubicacion.trim().length() < 3) {
            throw new TourInvalidoException(
                    "La ubicación debe tener al menos 3 caracteres."
            );
        }

        if (precioAdulto <= 0) {
            throw new TourInvalidoException(
                    "El precio adulto debe ser mayor que cero."
            );
        }
    }
}