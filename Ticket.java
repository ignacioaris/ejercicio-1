import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.DoubleStream;
public class Ticket {

    static <T> DoubleStream getPrecio(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private String numeroTicket;
    private LocalDate fechaCompra;
    private Localidad localidad;
    private double precio;

    private String generarNumeroTicket(LocalDate fecha, int correlativo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return fecha.format(formatter) + correlativo;
    }

    public Ticket(LocalDate fechaCompra, int correlativo, Localidad localidad2, double precio) {
        this.numeroTicket = generarNumeroTicket(fechaCompra, correlativo);
        this.fechaCompra = fechaCompra;
        this.localidad = localidad2;
        this.precio = precio;
    }


    

    // Getters y Setters

    

    public Ticket(LocalDate fechaCompra2, int correlativo, Localidad localidad2, int precio2) {
        //TODO Auto-generated constructor stub
    }

  
    

    String getNumeroTicket() {
        return numeroTicket;
    }

    public String getFechaCompra() {
        return getFechaCompra();
    }

    public String getLocalidad() {
        return localidad.getLocalidad();
    }

}
