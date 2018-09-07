package com.prakash.resource;

import com.codahale.metrics.annotation.Timed;
import com.prakash.dao.CustomerDAO;
import com.prakash.dao.ProductCategoryDAO;
import com.prakash.entity.Customer;
import com.prakash.entity.ProductCategory;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product-category")
@Api(value = "Product Category Resource")
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
    @ApiOperation(value = "get list of product categories")
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "get product category by id")
    public ProductCategory find(@PathParam("id") int id) {
        return productCategoryDAO.find(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "insert product category")
    public void insert(ProductCategory productCategory){
        productCategoryDAO.insert(productCategory);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    @ApiOperation(value = "delete product category")
    public void delete(@PathParam("id") int id){
        productCategoryDAO.delete(id);
    }
}
