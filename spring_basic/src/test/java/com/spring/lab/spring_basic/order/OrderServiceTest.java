package com.spring.lab.spring_basic.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.lab.spring_basic.discount.RateDiscountPolicy;
import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import com.spring.lab.spring_basic.member.MemberService;
import com.spring.lab.spring_basic.member.MemberServiceImpl;
import com.spring.lab.spring_basic.member.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  void beforeEach() {
    memberService = new MemberServiceImpl(new MemoryMemberRepository());
    orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
  }

  @Test
  void createOrder() {
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);
    Order order = orderService.createOrder(memberId, "itemA", 20_000);
    System.out.println("order = "
        + order); // Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}
    System.out.println("order.calculatePrice() = " + order.calculatePrice()); // 9000
    assertThat(order.calculatePrice()).isEqualTo(18_000);
    assertThat(order.getDiscountPrice()).isEqualTo(2_000);
  }
}
