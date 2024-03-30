package com.spring.lab.spring_basic.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  void beforeEach() {
    memberService = new MemberServiceImpl(new MemoryMemberRepository());
  }

  @Test
  void join() {
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);

    // when
    memberService.join(member);
    Member findMember = memberService.findMember(memberId);

    // then
    assertThat(member).isEqualTo(findMember);
  }
}
