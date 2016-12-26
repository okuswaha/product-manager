package com.prakash.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.prakash.api.Representation;
import com.prakash.dao.ProductDAO;
import com.prakash.modal.Product;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.dropwizard.hibernate.UnitOfWork;

import java.util.List;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private final String message;
    private final String defaultText1;
    private final String defaultText2;
    private ProductDAO productDAO;
    public ProductResource(String message, String defaultText1, String defaultText2, ProductDAO productDAO) {
        this.message = message;
        this.defaultText1 = defaultText1;
        this.defaultText2 = defaultText2;
        this.productDAO = productDAO;
    }

    @GET
    @Timed
    public Representation sayHello(@QueryParam("param1") Optional<String> param1, @QueryParam("param2") Optional<String> param2) {
        final String value = String.format(message, param1.or(defaultText1),
        		param2.or(defaultText2));
        return new Representation(value);
    }

    @GET
    @Timed
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listProducts() {
        Product product = new Product();
        return Lists.newArrayList(product);
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/products/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<com.prakash.entity.Product> findAllProducts() {
        System.out.println("called");
        return productDAO.findAll();
    }
}
