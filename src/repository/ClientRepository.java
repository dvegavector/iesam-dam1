package repository;

import features.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientRepository {

    // Singleton
    private static ClientRepository instance;

    private Map<Integer, Client> clientes;

    private ClientRepository() {
        clientes = new HashMap<>();
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    // Operaciones CRUD básicas

    public void addCliente(Client client) {
        clientes.put(client.getId(), client);
    }

    public Client getClienteById(int id) {
        return clientes.get(id);
    }

    public Collection<Client> getAllClientes() {
        return clientes.values();
    }

    public void deleteCliente(int id) {
        clientes.remove(id);
    }

    public void updateCliente(Client client) {
        // Si ya existe, lo sustituimos. Si no existe, lo añadimos.
        clientes.put(client.getId(), client);
    }
}