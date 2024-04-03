package com.spring.lab.spring_mvc_1.web.frontcontroller.v3.controller;

import com.spring.lab.spring_mvc_1.domain.mamber.Member;
import com.spring.lab.spring_mvc_1.domain.mamber.MemberRepository;
import com.spring.lab.spring_mvc_1.web.frontcontroller.ModelView;
import com.spring.lab.spring_mvc_1.web.frontcontroller.v3.ControllerV3;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> paramMap) {
    List<Member> members = memberRepository.findAll();
    ModelView modelView = new ModelView("members");
    modelView.getModel().put("members", members);
    return modelView;
  }
}
