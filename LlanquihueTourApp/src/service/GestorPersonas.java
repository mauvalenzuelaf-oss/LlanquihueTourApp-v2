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

        // Crea la colección donde se almacenarán las personas válidas
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try {
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

                    // Comprueba que la línea contenga los seis campos requeridos
                    if (partes.length != 6) {
                        throw new PersonaInvalidaException(
                                "La línea debe contener seis campos."
                        );
                    }

                    // Obtiene y limpia cada dato de la línea
                    String nombre = partes[0].trim();
                    String relacionEmpresa = partes[1].trim();
                    String nombreCargo = partes[2].trim();
                    String organizacion = partes[3].trim();
                    String comunaCargo = partes[4].trim();

                    // Convierte el tiempo en el cargo desde texto a número entero
                    int tiempoCargo =
                            Integer.parseInt(partes[5].trim());

                    // Valida los datos principales de la persona
                    ValidadorDatosPersona.validarPersona(
                            nombre,
                            relacionEmpresa
                    );

                    // Valida los datos correspondientes al cargo
                    ValidadorDatosCargo.validarCargo(
                            nombreCargo,
                            organizacion,
                            comunaCargo,
                            tiempoCargo
                    );

                    // Crea primero el objeto Cargo
                    Cargo cargo = new Cargo(
                            nombreCargo,
                            organizacion,
                            comunaCargo,
                            tiempoCargo
                    );

                    // Crea la Persona incorporando el objeto Cargo (composición)
                    Persona persona = new Persona(
                            nombre,
                            relacionEmpresa,
                            cargo
                    );

                    // Agrega la persona válida a la colección
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

                // Avanza el contador para la siguiente línea
                numeroLinea++;
            }

            // Cierra el lector después de terminar la lectura
            lector.close();

        } catch (IOException e) {
            System.out.println(
                    "Error al leer el archivo de personas: "
                            + e.getMessage()
            );
        }

        // Devuelve la colección con las personas cargadas correctamente
        return listaPersonas;
    }
}