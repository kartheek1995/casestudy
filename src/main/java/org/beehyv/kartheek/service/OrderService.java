package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.model.Order;

public interface OrderService {
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int id);
	public Order getOrderById(int id);
	public List<Order> listOrdersByUserId(int id);
	public List<Order> listAllOrders();
}
