package com.spring.lab.spring_basic.discount;

import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

  private final int discountFixAmount = 1000; // 1000원 할인

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    return 0;
  }
}