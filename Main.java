import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Localidad> localidades = Arrays.asList(
            new Localidad("Localidad 1", 100, 100),
            new Localidad("Localidad 5", 100, 500),
            new Localidad("Localidad 10", 100, 1000)
        );

        VentaBoletos ventaBoletos = new VentaBoletos(localidades);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Comprar boletos");
            System.out.println("2. Consultar disponibilidad total");
            System.out.println("3. Consultar disponibilidad por localidad");
            System.out.println("4. Reporte de caja");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Cantidad de boletos: ");
                    int cantidadBoletos = scanner.nextInt();
                    System.out.print("Presupuesto máximo: ");
                    double presupuesto = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    System.out.println("Selecciona la localidad (1, 5, 10): ");
                    int localidadSeleccionada = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character

                    Comprador comprador = new Comprador(nombre, email, cantidadBoletos, presupuesto);
                    List<Ticket> ticketsComprados = ventaBoletos.agregarComprador(comprador);
                    if (ticketsComprados != null && !ticketsComprados.isEmpty()) {
                        System.out.println("Compra realizada con éxito. Detalles del ticket y de la compra:");
                        for (Ticket ticket : ticketsComprados) {
                            System.out.println("Número del Ticket: " + ticket.getNumeroTicket());
                            System.out.println("Fecha de Compra: " + ticket.getFechaCompra());
                            System.out.println("Localidad: " + ticket.getLocalidad());
                            System.out.println("Precio: $" + Ticket.getPrecio(null));
                        }
                    } else {
                        System.out.println("No se pudo realizar la compra. Verifique la disponibilidad o el presupuesto.");
                    }
                    break;
                case 2:
                    ventaBoletos.consultarDisponibilidadTotal();
                    break;
                case 3:
                    System.out.print("Selecciona la localidad (0: Localidad 1, 1: Localidad 5, 2: Localidad 10): ");
                    int localidadId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    ventaBoletos.consultarDisponibilidadPorLocalidad(localidadId);
                    break;
                case 4:
                    ventaBoletos.reporteCaja();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
