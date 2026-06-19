package model;

/**
 * Representa un destino turístico ofrecido por Llanquihue Tour.
 * Cada tour contiene nombre, tipo, ubicación y precio para adulto.
 */
public class Tour {

    // Atributos de la clase
    private String nombre;
    private String tipo;
    private String ubicacion;
    private int precioAdulto;

    // Constructor sin parámetros
    public Tour() {
        this.nombre = "nombre tour";
        this.tipo = "tipo tour";
        this.ubicacion = "comuna";
        this.precioAdulto = 30000;
    }

    /**
     * Constructor con parámetros.
     * Crea un tour con sus datos principales.
     *
     * @param nombre nombre del tour
     * @param tipo tipo de tour
     * @param ubicacion comuna o lugar donde se realiza el tour
     * @param precioAdulto precio del tour para una persona adulta
     */
    public Tour(String nombre, String tipo, String ubicacion, int precioAdulto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precioAdulto = precioAdulto;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPrecioAdulto() {
        return precioAdulto;
    }

    public void setPrecioAdulto(int precioAdulto) {
        this.precioAdulto = precioAdulto;
    }

    /**
     * Método toString
     * Devuelve la información del tour en formato de texto.
     *
     * @return datos del tour formateados como texto
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " | Tipo: " + tipo +
                " | Ubicación: " + ubicacion +
                " | Precio: $" + precioAdulto;
    }
}
