package com.programacion.servicios;

import com.programacion.dto.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ServicioCustomer {
    public static final String URL = "http://localhost:8080/customers/";

    public List<Customer> listarTodos() throws Exception {
        Client client = ClientBuilder.newClient();

        Customer[] customers = client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .get(Customer[].class);

        return Arrays.asList(customers);
    }

    public void insertar(Customer obj) throws Exception {
        Client client = ClientBuilder.newClient();

        Entity<Customer> entity = Entity.entity(obj, MediaType.APPLICATION_JSON);

        client.target(URL).request().post(entity);

    }

    public void modificar(Integer id, Customer obj) throws Exception {
        Client client = ClientBuilder.newClient();
        Entity<Customer> entity = Entity.entity(obj, MediaType.APPLICATION_JSON);
        client.target(URL+id).request().put(entity);

    }

    public Customer findById(Integer id) throws Exception {

        Client client = ClientBuilder.newClient();

        Customer customer = client.target(URL+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Customer.class);
        return customer;
    }

    public void eliminar(Integer id) throws  Exception{
        Client client = ClientBuilder.newClient();
        client.target(URL+id).request().delete();
    }
}
