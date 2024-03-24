package com.spring.lab.spring_basic.beanfind;

import com.spring.lab.spring_basic.AppConfig;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> {
      Object bean = ac.getBean(beanDefinitionName);
      System.out.println("name = " + beanDefinitionName + " object = " + bean);
    });
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> {
      BeanDefinition bean = ac.getBeanDefinition(beanDefinitionName);
      if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object beanObject = ac.getBean(beanDefinitionName);
        System.out.println("name = " + beanDefinitionName + " object = " + beanObject);
      } else {
        System.out.println("name = " + beanDefinitionName + " object = " + bean);
      }
    });
  }
}
