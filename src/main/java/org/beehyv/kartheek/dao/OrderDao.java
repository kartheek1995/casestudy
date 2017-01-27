package org.beehyv.kartheek.dao;

import java.util.List;

import org.beehyv.kartheek.model.Order;

public interface OrderDao {
	public void addOrder(Order order);
	public List<Order> listOrdersByUserId(int userId);
	public List<Order> listAllOrders();
	public Order getOrderById(int orderId);
	public void deleteOrder(int orderId);
}
