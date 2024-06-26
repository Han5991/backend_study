package com.spring.lab.spring_basic.discount;

import com.spring.lab.spring_basic.annotation.MainDiscountPolicy;
import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    }
    return 0;
  }
}
