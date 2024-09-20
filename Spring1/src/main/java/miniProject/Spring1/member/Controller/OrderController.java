package miniProject.Spring1.member.Controller;

import miniProject.Spring1.member.Order;
import miniProject.Spring1.member.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String showOrders(Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/orders/create")
    public String showCreateOrderForm() {
        return "create_order";  // 주문 생성 폼으로 이동 (create_order.html)
    }

    @PostMapping("/orders/create")
    public String createOrder(@RequestParam Long memberId,
                             @RequestParam String itemName,
                             @RequestParam int itemPrice){
        orderService.createOrder(memberId, itemName, itemPrice);

        return "redirect:/orders";
    }



}
