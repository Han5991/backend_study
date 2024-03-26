package com.spring.lab.spring_basic.member;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Autowired // ac.getBean(MemberRepository.class)로 MemberRepository를 찾아서 주입해준다.
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
