package com.prakash.dao;

import com.prakash.entity.Customer;
import com.prakash.entity.OrderDetails;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by kuswaha on 12/25/16.
 */
public class OrderDetailsDAO extends AbstractDAO<OrderDetails> {
    public OrderDetailsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<OrderDetails> findAll() {
        Query query = currentSession().createQuery("from OrderDetails");
        List<OrderDetails> orderDetails =  (List<OrderDetails>) query.list();
        return orderDetails;
    }

    public OrderDetails find(int id) {
        Query query = currentSession().createQuery("from OrderDetails where orderId = :id");
        query.setParameter("id",new Integer(id));
        List<OrderDetails> orderDetails= query.list();
        return orderDetails.get(0);
    }
    public void delete(int id){
        Query query = currentSession().createQuery("delete from OrderDetails where  orderId = :id");
        query.setParameter("id", new Integer(id));
        query.executeUpdate();
    }
     public void insert(OrderDetails orderDetails){
        currentSession().save(orderDetails);
     }
}
