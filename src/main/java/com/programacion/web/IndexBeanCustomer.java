package com.programacion.web;

import com.programacion.dto.Customer;
import com.programacion.servicios.ServicioCustomer;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("indexBeanCustomer")
@SessionScoped
public class IndexBeanCustomer implements Serializable {

    @Inject
    private ServicioCustomer servicio;

    @Getter
    private List<com.programacion.dto.Customer> customers;

    @Getter
    private Customer customer = new Customer();


    @PostConstruct
    void inicializar() throws Exception {
        customers = servicio.listarTodos();
    }


    public void insertar() throws Exception {
        servicio.insertar(customer);
        customers = servicio.listarTodos();
    }

    public void eliminar(Integer id) throws Exception {
        servicio.eliminar(id);
        customers = servicio.listarTodos();
    }

    public void editar() throws Exception {
        System.out.println(customer.getId() + customer.getName() + customer.getSurname());
        servicio.modificar(customer.getId(), customer);
        customers = servicio.listarTodos();
    }
}
