package com.prakash.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.prakash.api.Representation;
import com.prakash.dao.ProductDAO;
import com.prakash.modal.Product;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Path("/product")
@Api(value = "Product Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private ProductDAO productDAO;
    public ProductResource(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GET
    @Timed
    @Path("/list")
    @ApiOperation(value = "Get a list of products")
    public List<Product> listProducts() {
        Product product = new Product();
        return Lists.newArrayList(product);
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/products/list")
    @ApiOperation(value = "find all products")
    public List<com.prakash.entity.Product> findAllProducts() {
        System.out.println("called");
        return productDAO.findAllHql();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/products/{id}")
    @ApiOperation(value = "Get Product by id")
    public com.prakash.entity.Product findAllProducts(@PathParam("id") int id) {
        System.out.println("product called with id : "+ id);
        return productDAO.getProduct(id);
    }

    @POST
    @UnitOfWork
    @Path("/products")
    @ApiOperation(value = "insert product")
    public void addProduct(com.prakash.entity.Product product){
        productDAO.insert(product);
    }

    @DELETE
    @UnitOfWork
    @Path("/products/{id}")
    @ApiOperation(value = "delete product")
    public void deleteProduct(@PathParam("id") int id){
        productDAO.delete(id);
    }
}
