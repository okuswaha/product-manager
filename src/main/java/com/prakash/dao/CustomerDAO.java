package com.prakash.dao;

import com.prakash.entity.Customer;
import com.prakash.entity.Product;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kuswaha on 12/25/16.
 */
public class CustomerDAO extends AbstractDAO<Customer> {
    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Customer> findAll() {
        Query query = currentSession().createQuery("from Customer");
        List<Customer> customers =  (List<Customer>) query.list();
        return customers;
    }

    public Customer find(int id) {
        Query query = currentSession().createQuery("from Customer where customerId = :id");
        query.setParameter("id",new Integer(id));
        List<Customer> customers = query.list();
        return customers.get(0);
    }
    public void delete(int id){
        Query query = currentSession().createQuery("delete from Customer where  customerId = :id");
        query.setParameter("id", new Integer(id));
        query.executeUpdate();
    }
     public void insert(Customer customer){
        currentSession().save(customer);
     }
}
