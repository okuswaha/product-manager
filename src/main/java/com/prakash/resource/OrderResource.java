package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.OrderDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.Order;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderDAO orderDAO;
    public OrderResource(OrderDAO orderDAO) {
      this.orderDAO = orderDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/list")
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    public Order find(@PathParam("id") int id) {
        return orderDAO.find(id);
    }

    @POST
    @UnitOfWork
    public void insert(Order order){
        orderDAO.insert(order);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        orderDAO.delete(id);
    }
}
