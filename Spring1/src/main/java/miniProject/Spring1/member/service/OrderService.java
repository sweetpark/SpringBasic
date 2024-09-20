package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Long memberId, String itemName, int itemPrice );
    List<Order> findAll();
}
