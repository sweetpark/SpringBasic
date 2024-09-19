package miniProject.Spring1.member.discount;

import miniProject.Spring1.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
