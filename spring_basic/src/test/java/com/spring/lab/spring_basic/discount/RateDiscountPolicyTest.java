package com.spring.lab.spring_basic.discount;

import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    // VIP는 10% 할인이 적용되어야 한다.
    // 10000원을 VIP가 할인받으면 1000원이어야 한다.
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_discount() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int price = 10000;

        // when
        int discountPrice = discountPolicy.discount(member, price);

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    // VIP가 아닌 경우 할인이 적용되지 않아야 한다.
    // 10000원을 VIP가 아닌 회원이 할인받으면 0원이어야 한다.
    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되지 않아야 한다.")
    void not_vip_discount() {
        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        int price = 10000;

        // when
        int discountPrice = discountPolicy.discount(member, price);

        // then
        assertThat(discountPrice).isEqualTo(0);
    }
}
