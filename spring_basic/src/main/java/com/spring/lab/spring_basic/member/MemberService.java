package com.spring.lab.spring_basic.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
