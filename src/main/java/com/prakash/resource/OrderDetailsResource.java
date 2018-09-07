package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.OrderDetailsDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.OrderDetails;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order-details")
@Api(value = "Order Details Resource")
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
    @ApiOperation(value = "get the list of order details")
    @Path("/list")
    public List<OrderDetails> findAll() {
        return orderDetailsDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "get order details by id")
    public OrderDetails find(@PathParam("id") int id) {
        return orderDetailsDAO.find(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "insert order details")
    public void insert(OrderDetails orderDetails){
        orderDetailsDAO.insert(orderDetails);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "get order details by id")
    public void delete(@PathParam("id") int id){
        orderDetailsDAO.delete(id);
    }
}
