package com.spring.lab.spring_mvc_1.web.frontcontroller.v1.controller;

import com.spring.lab.spring_mvc_1.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String viewPath = "/WEB-INF/views/new-form.jsp";
    RequestDispatcher dispatch = request.getRequestDispatcher(viewPath);
    dispatch.forward(request, response);
  }
}
