package com.spring.lab.spring_mvc_1.web.frontcontroller.v3.contoller;

import com.spring.lab.spring_mvc_1.web.frontcontroller.ModelView;
import com.spring.lab.spring_mvc_1.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {


  @Override
  public ModelView process(Map<String, String> paramMap) {
    return new ModelView("new-form");
  }
}
