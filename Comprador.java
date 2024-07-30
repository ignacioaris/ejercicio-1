public class Comprador {
    private static final Object Localidad = null;
    private static final Object Object = null;
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    public int getPresupuesto() {
        return (int) presupuesto;
    }

    public Object getLocalidad() {
            return Localidad;
        
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    // Getters y Setters
}
