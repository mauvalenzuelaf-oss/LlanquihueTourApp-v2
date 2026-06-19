package service;

import model.Cargo;
import model.Persona;
import util.CargoInvalidoException;
import util.PersonaInvalidaException;
import util.ValidadorDatosCargo;
import util.ValidadorDatosPersona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de cargar datos de personas
 * vinculadas a Llanquihue Tour desde un archivo de texto.
 */
public class GestorPersonas {

    /**
     * Lee un archivo de texto con datos separados
     * por punto y coma.
     *
     * Cada línea debe tener el formato:
     * nombre;relacionEmpresa;nombreCargo;organizacion;comunaCargo;tiempoCargo
     *
     * @param rutaArchivo ruta del archivo que contiene las personas
     * @return lista dinámica de objetos Persona
     */
    public ArrayList<Persona> cargarPersonas(String rutaArchivo) {

        ArrayList<Persona> listaPersonas = new ArrayList<>();

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

                    if (partes.length != 6) {
                        throw new PersonaInvalidaException(
                                "La línea debe contener seis campos."
                        );
                    }

                    String nombre = partes[0].trim();
                    String relacionEmpresa = partes[1].trim();
                    String nombreCargo = partes[2].trim();
                    String organizacion = partes[3].trim();
                    String comunaCargo = partes[4].trim();
                    int tiempoCargo =
                            Integer.parseInt(partes[5].trim());

                    ValidadorDatosPersona.validarPersona(
                            nombre,
                            relacionEmpresa
                    );

                    ValidadorDatosCargo.validarCargo(
                            nombreCargo,
                            organizacion,
                            comunaCargo,
                            tiempoCargo
                    );

                    Cargo cargo = new Cargo(
                            nombreCargo,
                            organizacion,
                            comunaCargo,
                            tiempoCargo
                    );

                    Persona persona = new Persona(
                            nombre,
                            relacionEmpresa,
                            cargo
                    );

                    listaPersonas.add(persona);

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Error en la línea " + numeroLinea
                                    + ": el tiempo en el cargo debe ser un número entero."
                    );

                } catch (PersonaInvalidaException e) {
                    System.out.println(
                            "Error en la línea " + numeroLinea
                                    + ": " + e.getMessage()
                    );

                } catch (CargoInvalidoException e) {
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
                    "Error al leer el archivo de personas: "
                            + e.getMessage()
            );
        }

        return listaPersonas;
    }
}