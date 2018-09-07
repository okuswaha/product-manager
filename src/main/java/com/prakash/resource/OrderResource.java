package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.OrderDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.Order;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
@Api(value = "Order Resource")
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
    @ApiOperation(value = "get list of order")
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "get order by id")
    public Order find(@PathParam("id") int id) {
        return orderDAO.find(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "insert an order")
    public void insert(Order order){
        orderDAO.insert(order);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "delete an order")
    public void delete(@PathParam("id") int id){
        orderDAO.delete(id);
    }
}
