package miniProject.Spring1.member.discount;

import miniProject.Spring1.member.Grade;
import miniProject.Spring1.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private static int discountPrice = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPrice/ 100;
        }else{
            return 0;
        }
    }
}
