package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.Order;
import miniProject.Spring1.member.discount.DiscountPolicy;
import miniProject.Spring1.member.discount.FixDiscountPolicy;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.resource.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
