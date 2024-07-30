import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class VentaBoletos {
    private List<Ticket> ticketsVendidos;
    private List<Localidad> localidades;
    private int correlativo;

    public VentaBoletos(List<Localidad> localidades) {
        this.ticketsVendidos = new ArrayList<>();
        this.localidades = localidades;
        this.correlativo = 1;
    }

    public boolean validarPresupuesto(Comprador comprador, Localidad localidad) {
        return comprador.getPresupuesto() >= localidad.getPrecio() * comprador.getCantidadBoletos();
    }

    public Ticket generarTicket(Comprador comprador, Localidad localidad) {
        Ticket ticket = new Ticket(LocalDate.now(), correlativo, localidad, localidad.getPrecio());
        correlativo++;
        return ticket;
    }

    public List<Ticket> agregarComprador(Comprador comprador) {
        for (Localidad loc : localidades) {
            if (loc.getNombre().equals(comprador.getLocalidad())) {
                if (loc.validarDisponibilidad(comprador.getCantidadBoletos()) &&
                    validarPresupuesto(comprador, loc)) {
                    int boletosVendidos = loc.venderBoletos(comprador.getCantidadBoletos());
                    for (int i = 0; i < boletosVendidos; i++) {
                        ticketsVendidos.add(generarTicket(comprador, loc));
                    }
                }
            }
        }
        return ticketsVendidos;
    }

    public void consultarDisponibilidadTotal() {
        for (Localidad loc : localidades) {
            System.out.println("Localidad: " + loc.getNombre() + ", Boletos disponibles: " + loc.getCapacidad());
        }
    }

    public void consultarDisponibilidadPorLocalidad(int localidadId) {
        Localidad loc = localidades.get(localidadId);
        System.out.println("Localidad: " + loc.getNombre() + ", Boletos disponibles: " + loc.getCapacidad());
    }

    public void reporteCaja() {
        @SuppressWarnings("unchecked")
        double totalIngresos = ticketsVendidos.stream().mapToDouble((ToDoubleFunction<? super Ticket>) Ticket.getPrecio(null)).sum();
        System.out.println("Total ingresos: $" + totalIngresos);
    }

    List<Ticket> agregarComprador(Comprador comprador, int localidadSeleccionada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
