package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.prakash.api.Representation;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.ProductDAO;
import com.prakash.entity.Customer;
import com.prakash.modal.Product;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer")
@Api(value = "Customer Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private CustomerDAO customerDAO;
    public CustomerResource(CustomerDAO customerDAO) {
      this.customerDAO = customerDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/list")
    @ApiOperation(value = "find all")
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "find")
    public Customer find(@PathParam("id") int id) {
        return customerDAO.find(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "insert")
    public void insert(Customer customer){
        customerDAO.insert(customer);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "delete")
    public void delete(@PathParam("id") int id){
        customerDAO.delete(id);
    }
}
