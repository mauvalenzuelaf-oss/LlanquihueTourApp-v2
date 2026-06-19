package model;

/**
 * Representa una persona vinculada a la operación de Llanquihue Tour.
 * Esta clase aplica composición al contener un objeto de la clase Cargo.
 */
public class Persona {

    // Atributos
    private String nombre;
    private String relacionEmpresa;
    private Cargo cargo;

    // Constructor sin parámetros
    public Persona() {
        this.nombre = "nombre";
        this.relacionEmpresa = "relacion";
        this.cargo = new Cargo();
    }

    /**
     * Construye una persona con sus datos principales.
     *
     * @param nombre nombre de la persona o entidad
     * @param relacionEmpresa relación con Llanquihue Tour
     * @param cargo objeto que contiene los datos del cargo
     */
    public Persona(String nombre, String relacionEmpresa, Cargo cargo) {
        this.nombre = nombre;
        this.relacionEmpresa = relacionEmpresa;
        this.cargo = cargo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRelacionEmpresa() {
        return relacionEmpresa;
    }

    public void setRelacionEmpresa(String relacionEmpresa) {
        this.relacionEmpresa = relacionEmpresa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Método toString()
     * Devuelve la información completa de la persona.
     *
     * @return información formateada
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " | Relación con la empresa: " + relacionEmpresa +
                " | " + cargo;
    }
}