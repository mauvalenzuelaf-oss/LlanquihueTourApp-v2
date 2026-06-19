package app;

import model.Persona;
import model.Tour;
import service.GestorPersonas;
import service.GestorTours;

import java.util.ArrayList;

/**
 * Clase principal de LlanquihueTourApp.
 *
 * Ejecuta la carga de archivos, muestra los objetos creados
 * y aplica filtros sobre las colecciones.
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        String rutaTours = "resources/tours.txt";
        String rutaPersonas = "resources/personas.txt";

        GestorTours gestorTours = new GestorTours();
        GestorPersonas gestorPersonas = new GestorPersonas();

        ArrayList<Tour> listaTours =
                gestorTours.cargarTours(rutaTours);

        ArrayList<Persona> listaPersonas =
                gestorPersonas.cargarPersonas(rutaPersonas);

        System.out.println(
                "Tours cargados correctamente: " + listaTours.size()
        );

        System.out.println(
                "Personas cargadas correctamente: " + listaPersonas.size()
        );

        mostrarTours(listaTours);
        mostrarPersonas(listaPersonas);
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

        for (Tour tour : listaTours) {
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

        for (Tour tour : listaTours) {
            if (tour.getTipo()
                    .equalsIgnoreCase("ruta gastronomica")) {

                System.out.println(tour);
            }
        }
    }

    /**
     * Filtra y muestra las personas cuyo cargo es guía turístico.
     *
     * @param listaPersonas lista de personas y entidades
     */
    private static void filtrarGuiasTuristicos(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== GUÍAS TURÍSTICOS ====="
        );

        for (Persona persona : listaPersonas) {
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
     * @param listaPersonas lista de personas y entidades
     */
    private static void filtrarColaboradores(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== COLABORADORES ====="
        );

        for (Persona persona : listaPersonas) {
            if (persona.getRelacionEmpresa()
                    .equalsIgnoreCase("colaborador")) {

                System.out.println(persona);
            }
        }
    }

    /**
     * Filtra y muestra las personas o entidades relacionadas
     * como proveedores.
     *
     * @param listaPersonas lista de personas y entidades
     */
    private static void filtrarProveedores(
            ArrayList<Persona> listaPersonas) {

        System.out.println(
                "\n===== PROVEEDORES ====="
        );

        for (Persona persona : listaPersonas) {
            if (persona.getRelacionEmpresa()
                    .equalsIgnoreCase("proveedor")) {

                System.out.println(persona);
            }
        }
    }
}