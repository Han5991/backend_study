package com.spring.lab.spring_mvc_1.web.springmvc.v2;

import com.spring.lab.spring_mvc_1.domain.mamber.Member;
import com.spring.lab.spring_mvc_1.domain.mamber.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

  private MemberRepository memberRepository = MemberRepository.getInstance();

  @RequestMapping("/new-form")
  public ModelAndView newForm() {
    return new ModelAndView("new-form");
  }

  @RequestMapping
  public ModelAndView members() {
    List<Member> members = memberRepository.findAll();
    ModelAndView modelView = new ModelAndView("members");
    modelView.addObject("members", members);
    return modelView;
  }

  @RequestMapping("/save")
  public ModelAndView save(HttpServletRequest request) {
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

    ModelAndView modelView = new ModelAndView("save-result");
    modelView.addObject("member", member);
    return modelView;
  }
}
