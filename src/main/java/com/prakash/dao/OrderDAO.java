package com.prakash.dao;

import com.prakash.entity.Customer;
import com.prakash.entity.Order;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kuswaha on 12/25/16.
 */
public class OrderDAO extends AbstractDAO<Order> {
    public OrderDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Order> findAll() {
        Query query = currentSession().createQuery("from Order");
        List<Order> orders =  (List<Order>) query.list();
        return orders;
    }

    public Order find(int id) {
        Query query = currentSession().createQuery("from Order where orderId = :id");
        query.setParameter("id",new Integer(id));
        List<Order> orders = query.list();
        return orders.get(0);
    }
    public void delete(int id){
        Query query = currentSession().createQuery("delete from Order where  orderId = :id");
        query.setParameter("id", new Integer(id));
        query.executeUpdate();
    }
    public void insert(Order order){
        currentSession().save(order);
     }
}
