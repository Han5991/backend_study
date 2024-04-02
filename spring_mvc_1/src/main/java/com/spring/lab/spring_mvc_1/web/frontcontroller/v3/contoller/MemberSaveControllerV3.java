package com.spring.lab.spring_mvc_1.web.frontcontroller.v3.contoller;

import com.spring.lab.spring_mvc_1.domain.mamber.Member;
import com.spring.lab.spring_mvc_1.domain.mamber.MemberRepository;
import com.spring.lab.spring_mvc_1.web.frontcontroller.ModelView;
import com.spring.lab.spring_mvc_1.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @Override
  public ModelView process(Map<String, String> paramMap) {
    String username = paramMap.get("username");
    int age = Integer.parseInt(paramMap.get("age"));
    Member member = new Member(username, age);
    memberRepository.save(member);
    ModelView modelView = new ModelView("save-result");
    modelView.getModel().put("member", member);
    return modelView;
  }
}
