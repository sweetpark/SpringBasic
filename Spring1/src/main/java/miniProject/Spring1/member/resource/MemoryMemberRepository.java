package miniProject.Spring1.member.resource;

import miniProject.Spring1.member.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private Long sequence = 0L;
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member)
    {
        member.setId(++sequence);
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
}
