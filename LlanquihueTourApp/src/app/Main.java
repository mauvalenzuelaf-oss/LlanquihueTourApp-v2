package app;

import model.Persona;
import model.Tour;
import service.GestorPersonas;
import service.GestorTours;

import java.util.ArrayList;

/**
 * Clase principal de LlanquihueTourApp.
 *
 * Ejecuta la carga de archivos, muestra los objetos creados y aplica filtros sobre las colecciones.
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        // Define las rutas de los archivos externos
        String rutaTours = "resources/tours.txt";
        String rutaPersonas = "resources/personas.txt";

        // Crea los gestores encargados de leer los archivos
        GestorTours gestorTours = new GestorTours();
        GestorPersonas gestorPersonas = new GestorPersonas();

        // Carga los tours y los almacena en una colección
        ArrayList<Tour> listaTours =
                gestorTours.cargarTours(rutaTours);

        // Carga las personas y las almacena en una colección
        ArrayList<Persona> listaPersonas =
                gestorPersonas.cargarPersonas(rutaPersonas);

        // Muestra la cantidad de objetos cargados correctamente
        System.out.println(
                "Tours cargados correctamente: " + listaTours.size()
        );

        System.out.println(
                "Personas cargadas correctamente: " + listaPersonas.size()
        );

        // Muestra todos los objetos almacenados
        mostrarTours(listaTours);
        mostrarPersonas(listaPersonas);

        // Ejecuta los distintos filtros sobre las colecciones
        filtrarToursGastronomicos(listaTours);
        filtrarGuiasTuristicos(listaPersonas);
        filtrarEmpleados(listaPersonas);
        filtrarColaboradores(listaPersonas);
        filtrarProveedores(listaPersonas);
    }

    /**
     * Muestra todos los tours almacenados en la colección.
     *
     * @param listaTours lista de tours
     */
    private static void mostrarTours(ArrayList<Tour> listaTours) {

        System.out.println(
                "\n===== CATÁLOGO DE TOURS LLANQUIHUE TOUR ====="
        );

        // Recorre la colección completa mediante un ciclo for-each
        for (Tour tour : listaTours) {

            // Muestra cada objeto utilizando su método toString()
            System.out.println(tour);
        }
    }

    /**
     * Muestra todas las personas almacenadas.
     *
     * @param listaPersonas lista de personas
     */
    private static void mostrarPersonas(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== PERSONAS VINCULADAS ====="
        );

        // Recorre y muestra todas las personas
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }

    /**
     * Filtra y muestra los tours gastronómicos.
     *
     * @param listaTours lista de tours
     */
    private static void filtrarToursGastronomicos(
            ArrayList<Tour> listaTours) {

        System.out.println(
                "\n===== RUTAS GASTRONÓMICAS ====="
        );

        // Recorre todos los tours
        for (Tour tour : listaTours) {

            // Comprueba si el tipo corresponde a una ruta gastronómica
            if (tour.getTipo()
                    .equalsIgnoreCase("ruta gastronomica")) {

                // Muestra solamente los tours que cumplen la condición
                System.out.println(tour);
            }
        }
    }

    /**
     * Filtra y muestra las personas cuyo cargo es guía turístico.
     *
     * @param listaPersonas lista de personas
     */
    private static void filtrarGuiasTuristicos(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== GUÍAS TURÍSTICOS ====="
        );

        // Recorre todas las personas
        for (Persona persona : listaPersonas) {

            // Accede al Cargo contenido en Persona y compara su nombre
            if (persona.getCargo()
                    .getNombreCargo()
                    .equalsIgnoreCase("guia turistico")) {

                System.out.println(persona);
            }
        }
    }

    /**
     * Filtra y muestra las personas relacionadas como empleados.
     *
     * @param listaPersonas lista de personas
     */
    private static void filtrarEmpleados(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== EMPLEADOS ====="
        );

        // Recorre las personas y selecciona las relacionadas como empleados
        for (Persona persona : listaPersonas) {
            if (persona.getRelacionEmpresa()
                    .equalsIgnoreCase("empleado")) {

                System.out.println(persona);
            }
        }
    }

    /**
     * Filtra y muestra las personas relacionadas como colaboradores.
     *
     * @param listaPersonas lista de personas
     */
    private static void filtrarColaboradores(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== COLABORADORES ====="
        );

        // Recorre las personas y selecciona las relacionadas como colaboradores
        for (Persona persona : listaPersonas) {
            if (persona.getRelacionEmpresa()
                    .equalsIgnoreCase("colaborador")) {

                System.out.println(persona);
            }
        }
    }

    /**
     * Filtra y muestra las personas relacionadas como proveedores.
     *
     * @param listaPersonas lista de personas
     */
    private static void filtrarProveedores(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== PROVEEDORES ====="
        );

        // Recorre las personas y selecciona las relacionadas como proveedores
        for (Persona persona : listaPersonas) {
            if (persona.getRelacionEmpresa()
                    .equalsIgnoreCase("proveedor")) {

                System.out.println(persona);
            }
        }
    }
}
