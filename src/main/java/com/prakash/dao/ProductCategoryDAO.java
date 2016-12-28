package com.prakash.dao;

import com.prakash.entity.ProductCategory;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kuswaha on 12/25/16.
 */
public class ProductCategoryDAO extends AbstractDAO<ProductCategory> {
    public ProductCategoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<ProductCategory> findAll() {
        Query query = currentSession().createQuery("from ProductCategory");
        List<ProductCategory> productCategories =  (List<ProductCategory>) query.list();
        return productCategories;
    }

    public ProductCategory find(int id) {
        Query query = currentSession().createQuery("from ProductCategory where categoryId = :id");
        query.setParameter("id",new Integer(id));
        List<ProductCategory> productCategories = query.list();
        return productCategories.get(0);
    }
    public void delete(int id){
        Query query = currentSession().createQuery("delete from ProductCategory where  categoryId = :id");
        query.setParameter("id", new Integer(id));
        query.executeUpdate();
    }
     public void insert(ProductCategory productCategory){
        currentSession().save(productCategory);
     }
}
