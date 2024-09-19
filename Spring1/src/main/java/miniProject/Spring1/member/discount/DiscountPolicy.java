package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Member;

public interface DIscountPolicy {
    int discount(Member member, int price);

}
