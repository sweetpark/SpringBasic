package miniProject.Spring1.member.resource;

import miniProject.Spring1.member.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryOrderRepository implements OrderRepository{

    private static Map<Long, Order> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public void save(Order order) {
        order.setOrderId(++sequence);
        store.put(order.getOrderId(), order);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return Optional.ofNullable(store.get(orderId));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }
}
