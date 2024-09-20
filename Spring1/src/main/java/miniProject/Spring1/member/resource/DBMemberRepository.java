package miniProject.Spring1.member.resource;

import miniProject.Spring1.member.Member;

import java.util.List;

public class DBMemberRepository implements MemberRepository{
    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }

    @Override
    public List<Member> findAll(){
        return null;
    }
}
