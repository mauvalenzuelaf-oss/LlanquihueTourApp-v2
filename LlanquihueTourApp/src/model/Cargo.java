package model;

/**
 * Representa el cargo o función que cumple una persona vinculada a Llanquihue Tour.
 */
public class Cargo {

    // Atributos
    private String nombreCargo;
    private String organizacion;
    private String comunaCargo;
    private int tiempoCargo;

    // Constructor sin parámetros
    public Cargo() {
        this.nombreCargo = "cargo";
        this.organizacion = "Organización";
        this.comunaCargo = "comuna";
        this.tiempoCargo = 0;
    }

    /**
     * Construye un cargo con sus datos principales.
     *
     * @param nombreCargo nombre del cargo o función
     * @param organizacion organización donde se desempeña el cargo
     * @param comunaCargo comuna donde se desempeña
     * @param tiempoCargo cantidad de años en el cargo
     */
    public Cargo(String nombreCargo, String organizacion, String comunaCargo, int tiempoCargo) {
        this.nombreCargo = nombreCargo;
        this.organizacion = organizacion;
        this.comunaCargo = comunaCargo;
        this.tiempoCargo = tiempoCargo;
    }

    // Getters y Setters
    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getComunaCargo() {
        return comunaCargo;
    }

    public void setComunaCargo(String comunaCargo) {
        this.comunaCargo = comunaCargo;
    }

    public int getTiempoCargo() {
        return tiempoCargo;
    }

    public void setTiempoCargo(int tiempoCargo) {
        this.tiempoCargo = tiempoCargo;
    }

    /**
     * Método to String()
     * Devuelve la información del cargo en formato de texto.
     *
     * @return información formateada del cargo
     */
    @Override
    public String toString() {
        return "Cargo: " + nombreCargo
                + " | Organización: " + organizacion
                + " | Comuna: " + comunaCargo
                + " | Tiempo en el cargo: " + tiempoCargo + " años";
    }
}