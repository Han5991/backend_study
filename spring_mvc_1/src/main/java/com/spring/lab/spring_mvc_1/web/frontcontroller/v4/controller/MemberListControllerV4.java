package com.spring.lab.spring_mvc_1.web.frontcontroller.v4.controller;

import com.spring.lab.spring_mvc_1.domain.mamber.Member;
import com.spring.lab.spring_mvc_1.domain.mamber.MemberRepository;
import com.spring.lab.spring_mvc_1.web.frontcontroller.v4.ControllerV4;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public String process(Map<String, String> paramMap, Map<String, Object> model) {
    List<Member> members = memberRepository.findAll();
    model.put("members", members);
    return "members";
  }
}
