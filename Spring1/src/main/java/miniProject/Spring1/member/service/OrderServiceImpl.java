package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.Order;
import miniProject.Spring1.member.discount.DiscountPolicy;
import miniProject.Spring1.member.discount.FixDiscountPolicy;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.resource.MemoryMemberRepository;
import miniProject.Spring1.member.resource.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy, OrderRepository orderRepository){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        String memberName = member.getName();

        Order order = new Order(memberName, memberId, itemName, itemPrice, discountPrice);
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderRepository.findAll());
    }


}
