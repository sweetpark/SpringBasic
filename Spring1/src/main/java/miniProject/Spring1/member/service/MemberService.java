package miniProject.Spring1.member.service;

import miniProject.Spring1.member.Member;

import java.util.List;

public interface MemberService {
    void join(Member member);
    Member findById(Long memberId);
    List<Member> findAll();


}
