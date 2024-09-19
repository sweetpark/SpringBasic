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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
//        return new DBMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
