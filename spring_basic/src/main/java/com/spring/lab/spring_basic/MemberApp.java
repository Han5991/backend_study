package com.spring.lab.spring_basic;

import com.spring.lab.spring_basic.member.Grade;
import com.spring.lab.spring_basic.member.Member;
import com.spring.lab.spring_basic.member.MemberService;
import com.spring.lab.spring_basic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    orderService.createOrder(1L, "itemA", 20000);
    Member findMember = memberService.findMember(memberId);
    System.out.println("new member = " + member.getName());
    System.out.println("findMember = " + findMember.getName());
    System.out.println("findMember = " + findMember.getGrade());
  }
}
