package com.spring.lab.spring_basic.discount;

import com.spring.lab.spring_basic.member.Member;

public interface DiscountPolicy {

  int discount(Member member, int price);
}
