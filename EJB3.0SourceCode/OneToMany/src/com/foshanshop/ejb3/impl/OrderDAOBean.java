package com.foshanshop.ejb3.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.OrderDAO;
import com.foshanshop.ejb3.bean.Order;
import com.foshanshop.ejb3.bean.OrderItem;

@Stateless
@Remote ({OrderDAO.class})
public class OrderDAOBean implements OrderDAO {
    @PersistenceContext
    protected EntityManager em;
    
    public void insertOrder(){
        Order order = new Order();
        order.setCreatedate(new Date());
        order.addOrderItem(new OrderItem("笔记本电脑", new Float(13200.5)));
        order.addOrderItem(new OrderItem("U盘", new Float(620)));
        order.setAmount(new Float(13200.5+620));
        em.persist(order);
    }

    public Order getOrderByID(Integer orderid) {
       Order order =  em.find(Order.class, orderid);        
       order.getOrderItems().size();
       //因为是延迟加载，通过执行size()这种方式获取订单下的所有订单项
       return order;
    }

    public List getAllOrder() {
        Query query = em.createQuery("select DISTINCT o from Order o inner join fetch o.orderItems order by o.orderid");
        List result = query.getResultList();
        return result;
    }

}
