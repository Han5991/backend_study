package com.spring.lab.spring_basic.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.lab.spring_basic.AutoAppConfig;
import com.spring.lab.spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = context.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
