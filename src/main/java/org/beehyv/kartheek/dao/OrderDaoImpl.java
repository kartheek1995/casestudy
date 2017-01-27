package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer,Order> implements OrderDao{

	@Override
	public void addOrder(Order order) {
		persist(order);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> listOrdersByUserId(int userId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("user.userId", userId));
		return (List<Order>)criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> listAllOrders() {
		Criteria criteria = createEntityCriteria();
		return (List<Order>)criteria.list();
	}

	@Override
	public Order getOrderById(int orderId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("orderId", orderId));
		return (Order) criteria.uniqueResult();
	}

	@Override
	public void deleteOrder(int orderId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("orderId", orderId));
		delete((Order) criteria.uniqueResult());
	}

}
