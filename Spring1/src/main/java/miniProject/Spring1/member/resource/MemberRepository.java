package miniProject.Spring1.member.resource;

import miniProject.Spring1.member.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
    List<Member> findAll();
}
