package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.OrderDetailsDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.OrderDetails;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order-details")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderDetailsResource {
    private OrderDetailsDAO orderDetailsDAO;
    public OrderDetailsResource(OrderDetailsDAO orderDetailsDAO) {
      this.orderDetailsDAO = orderDetailsDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/list")
    public List<OrderDetails> findAll() {
        return orderDetailsDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    public OrderDetails find(@PathParam("id") int id) {
        return orderDetailsDAO.find(id);
    }

    @POST
    @UnitOfWork
    public void insert(OrderDetails orderDetails){
        orderDetailsDAO.insert(orderDetails);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        orderDetailsDAO.delete(id);
    }
}
