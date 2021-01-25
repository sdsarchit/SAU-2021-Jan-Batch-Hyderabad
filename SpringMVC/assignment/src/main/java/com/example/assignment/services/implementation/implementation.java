package com.example.assignment.services.implementation;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.assignment.model.Item;
import com.example.assignment.model.Order;
import com.example.assignment.services.services;

@Service
public class implementation implements services{
	static List<Order> orderList = new ArrayList<>();

    private boolean isItemDuplicate(int itemId, int orderIndex) {
        for(Item item : orderList.get(orderIndex).getItemList())
            if(item.getItemId() == itemId)
                return true;
        return false;
    }

    private int findOrderIndex(int orderId) {
        for(int i = 0; i < orderList.size(); i++)
            if(orderList.get(i).getOrderId() == orderId)
                return i;
        return -1;
    }

    private boolean isOrderDuplicate(int orderId) {
        for(Order order : orderList)
            if(order.getOrderId() == orderId)
                return true;
            return false;
    }

    private int findItemIndex(int itemId, int orderIndex) {
        for(int i = 0; i < orderList.get(orderIndex).getItemList().size(); i++)
            if(orderList.get(orderIndex).getItemList().get(i).getItemId() == itemId)
                return i;
        return -1;
    }

	@Override
	public String createNewOrder(Order order) {
		if(!isOrderDuplicate(order.getOrderId())) {
			orderList.add(order);
			return "new order created successfully";
		}
		return "Order already exists";
	}

	@Override
	public String addItemToOrder(Item item, int orderId) {
		int index=findOrderIndex(orderId);
		if(!isItemDuplicate(item.getItemId(), index)) {
			orderList.get(index).getItemList().add(item);
			return "Item successfully added";
		}
		return "Item already present at given order ID";
	}

	@Override
	public Order getOrderById(int orderId) {
		int ind=findOrderIndex(orderId);
		if(ind==-1) {
			return null;
		}
		return orderList.get(ind);
	}

	@Override
	public String deleteItemFromOrder(int orderId, int itemId) {
		int ind=findOrderIndex(orderId);
		if(ind!=-1) {
			int itemInd=findItemIndex(itemId, ind);
			if(itemInd!=-1) {
				orderList.get(ind).getItemList().remove(itemInd);
				return "Deletion successful";
			}
			return "Item not available at the order ID";
		}
		return "Order not available";
	}

	@Override
	public String updateItemQuantity(int orderId, int itemId, int quantity) {
		int ind=findOrderIndex(orderId);
		if(ind!=-1) {
			int itemInd=findItemIndex(itemId, ind);
			if(itemInd!=-1) {
				orderList.get(ind).getItemList().get(itemInd).setItemQuantity(quantity);;
				return "Updation successful";
			}
			return "Item not available at the order ID";
		}
		return "Order not available";
	}
	
}
