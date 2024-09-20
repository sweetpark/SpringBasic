package miniProject.Spring1.member.discount;

import miniProject.Spring1.member.Grade;
import miniProject.Spring1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static int discountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountPrice;
        }else{
            return 0;
        }
    }
}
