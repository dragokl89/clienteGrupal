package com.programacion.web;

import com.programacion.dto.Order;
import com.programacion.servicios.ServicioOrders;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("indexBeanOrder")
@SessionScoped
public class IndexBeanOrders implements Serializable {
    @Inject
    private ServicioOrders servicio;

    @Getter
    private List<Order> orders;

    @Getter private Order order = new Order();



    @PostConstruct
    void inicializar() throws Exception{
        orders = servicio.listarTodos();
    }


    public void insertar() throws Exception{
        servicio.insertar(order);
        orders = servicio.listarTodos();
    }

    public void eliminar(Integer id) throws Exception{
        servicio.eliminar(id);
        orders = servicio.listarTodos();
    }

    public void editar()throws Exception{
        System.out.println(order.getId()+order.getItem()+ order.getCustomer_id());
        servicio.modificar(order.getId(),order);
        orders = servicio.listarTodos();
    }
}

