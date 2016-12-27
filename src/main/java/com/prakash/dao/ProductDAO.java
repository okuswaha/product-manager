package com.prakash.dao;

import com.prakash.entity.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
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

    public List<Product> findAllHql() {
        Query query = currentSession().createQuery("from Product");
        List<Product> products =  query.list();
        return products;
    }

    public Product getProduct(Integer id) {
        Query query = currentSession().createQuery("from Product where id = :id");
        query.setParameter("id",new Integer(id));
        List<Product> products = query.list();
        return products.get(0);
    }
    public void delete(int id){
        Query query = currentSession().createQuery("delete from Product where  id = :id");
        query.setParameter("id", new Integer(id));
        query.executeUpdate();
    }
     public void insert(Product product){
        currentSession().save(product);
     }
}
