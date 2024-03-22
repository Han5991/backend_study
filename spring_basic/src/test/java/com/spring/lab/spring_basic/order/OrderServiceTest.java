package com.spring.lab.spring_basic.order;

import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import com.spring.lab.spring_basic.member.MemberService;
import com.spring.lab.spring_basic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order); // Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}
        System.out.println("order.calculatePrice() = " + order.calculatePrice()); // 9000
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
