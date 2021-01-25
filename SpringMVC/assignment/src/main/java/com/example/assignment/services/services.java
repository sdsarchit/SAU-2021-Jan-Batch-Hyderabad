package com.example.assignment.services;

import com.example.assignment.model.Item;
import com.example.assignment.model.Order;

public interface services {
	public String createNewOrder(Order order);
    public String addItemToOrder(Item item, int orderId);
    public Order getOrderById(int orderId);
    public String deleteItemFromOrder(int orderId, int itemId);
    public String updateItemQuantity(int orderId, int itemId, int quantity);
}
