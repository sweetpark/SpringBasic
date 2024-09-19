package miniProject.Spring1;

import miniProject.Spring1.member.service.MemberService;
import miniProject.Spring1.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    // ApplicationContext가 스프링이 관리하는 컨테이너를 의미함
    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(AppConfig.class);
            // AppConfig 자바, AppConfig XML, AppConfig .. 여러가지 기능 존재 (여러 파일을 이용하여 AppConfig구성 가능)
    @Test
    @DisplayName("빈 이름으로 조회") void findBeanByName() {
        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        org.assertj.core.api.Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회") void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        org.assertj.core.api.Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회") void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService",
                MemberServiceImpl.class);
        org.assertj.core.api.Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X") void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxx", MemberService.class));
    }
}
