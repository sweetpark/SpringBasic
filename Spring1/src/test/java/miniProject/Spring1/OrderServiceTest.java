package miniProject.Spring1;

import miniProject.Spring1.member.Grade;
import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.Order;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.service.MemberService;
import miniProject.Spring1.member.service.MemberServiceImpl;
import miniProject.Spring1.member.service.OrderService;
import miniProject.Spring1.member.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private static MemberService memberService = new MemberServiceImpl();
    private static OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
