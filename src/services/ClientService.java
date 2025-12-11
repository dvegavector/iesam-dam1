package services;

import features.Client;
import repository.ClientRepository;

import java.util.Collection;

public class ClientService {

    private ClientRepository repository;

    public ClientService() {
        this.repository = ClientRepository.getInstance();
    }

    public void crearCliente(Client client) {
        repository.addCliente(client);
    }

    public Client obtenerClientePorId(int id) {
        return repository.getClienteById(id);
    }

    public Collection<Client> obtenerTodosLosClientes() {
        return repository.getAllClientes();
    }

    public void eliminarCliente(int id) {
        repository.deleteCliente(id);
    }

    public void modificarCliente(Client client) {
        repository.updateCliente(client);
    }
}