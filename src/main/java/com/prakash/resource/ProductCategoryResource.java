package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.ProductCategoryDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.ProductCategory;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product-category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductCategoryResource {
    private ProductCategoryDAO productCategoryDAO;
    public ProductCategoryResource(ProductCategoryDAO productCategoryDAO) {
      this.productCategoryDAO = productCategoryDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/list")
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    public ProductCategory find(@PathParam("id") int id) {
        return productCategoryDAO.find(id);
    }

    @POST
    @UnitOfWork
    public void insert(ProductCategory productCategory){
        productCategoryDAO.insert(productCategory);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        productCategoryDAO.delete(id);
    }
}
