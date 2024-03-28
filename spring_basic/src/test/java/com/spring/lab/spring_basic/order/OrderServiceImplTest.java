package com.spring.lab.spring_basic.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.lab.spring_basic.discount.FixDiscountPolicy;
import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import com.spring.lab.spring_basic.member.MemberRepository;
import com.spring.lab.spring_basic.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L, "memberA", Grade.VIP));
    OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),
        new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "itemA", 10_000);
    assertThat(order.getDiscountPrice()).isEqualTo(1_000);
  }

}
