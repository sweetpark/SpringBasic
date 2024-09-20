package miniProject.Spring1.member.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.resource.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
