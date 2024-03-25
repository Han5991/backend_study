package com.spring.lab.spring_basic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(
        TestConfig.class);

    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    // Thread A: A 사용자 10000원 주문
    int userA = statefulService1.order("userA", 10000);
    // Thread B: B 사용자 20000원 주문
    int userB = statefulService2.order("userB", 20000);

    // Thread A: 사용자 A 주문 금액 조회
    System.out.println("price = " + userA);

    // Thread B: 사용자 B 주문 금액 조회
    System.out.println("price2 = " + userB);
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }

}
