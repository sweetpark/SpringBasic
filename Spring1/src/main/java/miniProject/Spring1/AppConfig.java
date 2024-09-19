package miniProject.Spring1;

import miniProject.Spring1.member.Order;
import miniProject.Spring1.member.discount.DiscountPolicy;
import miniProject.Spring1.member.discount.FixDiscountPolicy;
import miniProject.Spring1.member.discount.RateDiscountPolicy;
import miniProject.Spring1.member.resource.DBMemberRepository;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.resource.MemoryMemberRepository;
import miniProject.Spring1.member.service.MemberService;
import miniProject.Spring1.member.service.MemberServiceImpl;
import miniProject.Spring1.member.service.OrderService;
import miniProject.Spring1.member.service.OrderServiceImpl;
import org.springframework.util.unit.DataSize;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
//        return new DBMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
