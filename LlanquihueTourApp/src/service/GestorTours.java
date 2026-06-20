package service;

import model.Tour;
import util.TourInvalidoException;
import util.ValidadorDatosTour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de cargar datos de tours
 * desde un archivo de texto.
 */
public class GestorTours {

    /**
     * Lee un archivo de texto con datos de tours
     * separados por punto y coma.
     *
     * Cada línea debe tener el formato:
     * nombre;tipo;ubicacion;precioAdulto
     *
     * @param rutaArchivo ruta del archivo que contiene los tours
     * @return lista dinámica de objetos Tour
     */
    public ArrayList<Tour> cargarTours(String rutaArchivo) {

        // Lista donde se almacenarán los tours
        ArrayList<Tour> listaTours = new ArrayList<>();

        try {
            // Abre el archivo indicado para leerlo
            BufferedReader lector =
                    new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            // Permite indicar en qué línea se produjo un error
            int numeroLinea = 1;

            // Lee el archivo línea por línea hasta llegar al final
            while ((linea = lector.readLine()) != null) {

                // Omite las líneas vacías
                if (linea.trim().isEmpty()) {
                    numeroLinea++;
                    continue;
                }

                try {
                    // Separa los datos utilizando el punto y coma
                    String[] partes = linea.split(";", -1);

                    // Comprueba que la línea contenga los cuatro campos requeridos
                    if (partes.length != 4) {
                        throw new TourInvalidoException(
                                "La línea debe contener cuatro campos."
                        );
                    }

                    // Obtiene y limpia los datos de texto de la línea
                    String nombre = partes[0].trim();
                    String tipo = partes[1].trim();
                    String ubicacion = partes[2].trim();

                    // Convierte el precio desde texto a número entero
                    int precioAdulto = Integer.parseInt(partes[3].trim());

                    // Valida los datos antes de crear el objeto Tour
                    ValidadorDatosTour.validarTour(
                            nombre,
                            tipo,
                            ubicacion,
                            precioAdulto
                    );

                    // Crea el objeto Tour con los datos validados
                    Tour tour = new Tour(
                            nombre,
                            tipo,
                            ubicacion,
                            precioAdulto
                    );

                    // Agrega el tour válido a la colección
                    listaTours.add(tour);

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Error en la línea " + numeroLinea
                                    + ": el precio debe ser un número entero."
                    );

                } catch (TourInvalidoException e) {
                    System.out.println(
                            "Error en la línea " + numeroLinea
                                    + ": " + e.getMessage()
                    );
                }

                // Avanza el contador para la siguiente línea
                numeroLinea++;
            }

            // Cierra el lector después de terminar la lectura
            lector.close();

        } catch (IOException e) {
            System.out.println(
                    "Error al leer el archivo de tours: "
                            + e.getMessage()
            );
        }

        // Devuelve la colección con los tours cargados correctamente
        return listaTours;
    }
}
