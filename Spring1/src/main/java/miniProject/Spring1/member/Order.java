package miniProject.Spring1.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long orderId;
    private String memberName;
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    private int finalPrice;

    public Order(String memberName, Long memberId, String itemName, int itemPrice, int discountPrice){
        this.memberName = memberName;
        this.memberId= memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = itemPrice - discountPrice;
    }
}
