package com.spring.lab.spring_mvc_1.domain.mamber;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Member member = new Member("hello", 20);
    // when
    Member savedMember = memberRepository.save(member);
    // then
    Member findMember = memberRepository.findById(savedMember.getId());
    assertThat(findMember).isEqualTo(savedMember);
  }

  @Test
  void findAll() {
    // given
    Member member1 = new Member("member1", 20);
    Member member2 = new Member("member2", 30);
    memberRepository.save(member1);
    memberRepository.save(member2);
    // when
    // then
    assertThat(memberRepository.findAll().size()).isEqualTo(2);
  }
}
