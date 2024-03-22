package com.spring.lab.spring_basic.order;

import com.spring.lab.spring_basic.discount.DiscountPolicy;
import com.spring.lab.spring_basic.discount.FIxDiscountPolicy;
import com.spring.lab.spring_basic.member.Member;
import com.spring.lab.spring_basic.member.MemberRepository;
import com.spring.lab.spring_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
