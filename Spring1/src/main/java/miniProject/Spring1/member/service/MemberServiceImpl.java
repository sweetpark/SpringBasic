package miniProject.Spring1.member.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.resource.MemberRepository;
import miniProject.Spring1.member.resource.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    //Lombok @RequiredArgsConstructor 를 사용할경우, final 붙은 멤버변수의 생성자를 자동으로 생성시킴 -> 생성자가 2개 이상이면 @Autowired를 붙여서 생성해야함
    //생성자 주입 ( 생성자가 1개일때는 autowired 생략가능 )
//    @Autowired
//    public MemberServiceImpl(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    // 수정자 주입
    //@Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    // 필드 주입
//    @Autowired
//    private MemberRepository memberRepository;

    // 일반 메서드 주입
//    @Autowired
//    void init(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @PostConstruct
    public void init(){
        System.out.println("초기화 콜백");
    }

    @PreDestroy
    public void close(){
        System.out.println("종료 전 콜백");
    }
}
