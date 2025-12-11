import features.Client;
import services.ClientService;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        ClientService clientService = new ClientService();

        System.out.println("=== Muebles SL - Gestión de Clientes ===");

        // 1. Instanciar dos clientes
        Client c1 = new Client(
                1,
                "Ana",
                "García López",
                "12345678A",
                "Calle Mayor 1",
                "Madrid",
                "Madrid",
                "600111222",
                "ana@example.com"
        );

        Client c2 = new Client(
                2,
                "Luis",
                "Pérez Martín",
                "87654321B",
                "Avenida Sol 10",
                "Sevilla",
                "Sevilla",
                "600333444",
                "luis@example.com"
        );

        // 2. Dar de alta ambos clientes en la BD
        clientService.crearCliente(c1);
        clientService.crearCliente(c2);

        // 3. Listar todos los clientes
        System.out.println("\n--- Listado inicial de clientes ---");
        imprimirClientes(clientService.obtenerTodosLosClientes());

        // 4. Modificar uno (por ID)
        System.out.println("\n--- Modificar cliente con ID = 1 ---");
        Client clientAModificar = clientService.obtenerClientePorId(1);
        if (clientAModificar != null) {
            clientAModificar.setTelefono("699999999");
            clientAModificar.setEmail("ana.modificado@example.com");
            clientService.modificarCliente(clientAModificar);
        }

        // 5. Listar de nuevo los clientes
        System.out.println("\n--- Listado de clientes tras la modificación ---");
        imprimirClientes(clientService.obtenerTodosLosClientes());

        // 6. Borrar un cliente
        System.out.println("\n--- Eliminar cliente con ID = 2 ---");
        clientService.eliminarCliente(2);

        // 7. Listar los clientes
        System.out.println("\n--- Listado final de clientes ---");
        imprimirClientes(clientService.obtenerTodosLosClientes());

        // 8. Fin
        System.out.println("\n=== Fin del programa ===");
    }

    private static void imprimirClientes(Collection<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("No hay clientes.");
        } else {
            for (Client c : clients) {
                System.out.println(c);
            }
        }
    }
}