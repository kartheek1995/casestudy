package org.beehyv.kartheek.service;

import java.util.List;

import org.beehyv.kartheek.dao.OrderDao;
import org.beehyv.kartheek.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	public OrderDao orderdao;

	@Override
	public void addOrder(Order order) {
		orderdao.addOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		Order temporder = orderdao.getOrderById(order.getOrderId());
		if(temporder!=null){
			temporder.setDate(order.getDate());
			temporder.setOrderproduct(order.getOrderproduct());
			temporder.setQuantity(order.getQuantity());
			temporder.setShippingaddress(order.getShippingaddress());
			temporder.setUser(order.getUser());
		}
	}

	@Override
	public void deleteOrder(int id) {
		orderdao.deleteOrder(id);
	}

	@Override
	public Order getOrderById(int id) {
		return orderdao.getOrderById(id);
	}

	@Override
	public List<Order> listOrdersByUserId(int id) {
		return orderdao.listOrdersByUserId(id);
	}

	@Override
	public List<Order> listAllOrders() {
		return orderdao.listAllOrders();
	}
}
