package miniProject.Spring1.member.resource;

import miniProject.Spring1.member.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);

    Optional<Order> findById(Long orderId);

    List<Order> findAll();
}
