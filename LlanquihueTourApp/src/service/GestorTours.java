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
            BufferedReader lector =
                    new BufferedReader(new FileReader(rutaArchivo));

            String linea;
            int numeroLinea = 1;

            while ((linea = lector.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    numeroLinea++;
                    continue;
                }

                try {
                    String[] partes = linea.split(";", -1);

                    if (partes.length != 4) {
                        throw new TourInvalidoException(
                                "La línea debe contener cuatro campos."
                        );
                    }

                    String nombre = partes[0].trim();
                    String tipo = partes[1].trim();
                    String ubicacion = partes[2].trim();
                    int precioAdulto = Integer.parseInt(partes[3].trim());

                    ValidadorDatosTour.validarTour(
                            nombre,
                            tipo,
                            ubicacion,
                            precioAdulto
                    );

                    Tour tour = new Tour(
                            nombre,
                            tipo,
                            ubicacion,
                            precioAdulto
                    );

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

                numeroLinea++;
            }

            lector.close();

        } catch (IOException e) {
            System.out.println(
                    "Error al leer el archivo de tours: "
                            + e.getMessage()
            );
        }

        return listaTours;
    }
}
