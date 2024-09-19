package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice );
}
