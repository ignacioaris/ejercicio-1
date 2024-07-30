public class Localidad {
    private String nombre;
    private int capacidad;
    private double precio;

    public Localidad(String nombre, int capacidad, double precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public boolean validarDisponibilidad(int cantidad) {
        return capacidad >= cantidad;
    }

    public int venderBoletos(int cantidad) {
        if (validarDisponibilidad(cantidad)) {
            capacidad -= cantidad;
            return cantidad;
        } else {
            int vendidos = capacidad;
            capacidad = 0;
            return vendidos;
        }
    }

    public int getPrecio() {
        return (int) precio;
    }

    public String getNombre() 
    {
        return this.nombre = nombre;
    }

    public String getCapacidad() {
       return String.valueOf(capacidad);
    }

    public String getLocalidad() {
        return getLocalidad();
    }

    // Getters y Setters
}
