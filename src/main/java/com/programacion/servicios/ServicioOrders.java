package com.programacion.servicios;

import com.programacion.dto.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ServicioOrders {
    public static final String URL = "http://localhost:8080/orders/";

    public List<Order> listarTodos() throws Exception {


        Client client = ClientBuilder.newClient();

        Order[] orders = client.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .get(Order[].class);

        return Arrays.asList(orders);
    }

    public void insertar(Order obj) throws Exception {
        Client client = ClientBuilder.newClient();

        Entity<Order> entity = Entity.entity(obj, MediaType.APPLICATION_JSON);

        client.target(URL).request().post(entity);

    }

    public void modificar(Integer id, Order obj) throws Exception {
        Client client = ClientBuilder.newClient();

        Entity<Order> entity = Entity.entity(obj, MediaType.APPLICATION_JSON);
        client.target(URL+id).request().put(entity);

    }

    public Order findById(Integer id) throws Exception {

        Client client = ClientBuilder.newClient();

        Order Order = client.target(URL+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Order.class);

        return Order;
    }

    public void eliminar(Integer id) throws  Exception{
        Client client = ClientBuilder.newClient();
        client.target(URL+id).request().delete();

    }

}
