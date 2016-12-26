package com.prakash.dao;

import com.prakash.entity.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kuswaha on 12/25/16.
 */
public class ProductDAO extends AbstractDAO<Product> {
    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Product> findAll() {
        List<Product> products = list(namedQuery("findAll"));
        System.err.println("size of products : "+ products.size());
        return products ;
    }
}
