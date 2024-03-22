package com.spring.lab.spring_basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(memberId);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
