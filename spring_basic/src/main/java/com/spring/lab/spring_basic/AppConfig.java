package com.spring.lab.spring_basic;

import com.spring.lab.spring_basic.discount.DiscountPolicy;
import com.spring.lab.spring_basic.discount.RateDiscountPolicy;
import com.spring.lab.spring_basic.member.MemberRepository;
import com.spring.lab.spring_basic.member.MemberService;
import com.spring.lab.spring_basic.member.MemberServiceImpl;
import com.spring.lab.spring_basic.member.MemoryMemberRepository;
import com.spring.lab.spring_basic.order.OrderService;
import com.spring.lab.spring_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
