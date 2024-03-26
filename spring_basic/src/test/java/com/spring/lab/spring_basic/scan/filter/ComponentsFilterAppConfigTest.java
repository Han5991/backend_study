package com.spring.lab.spring_basic.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class ComponentsFilterAppConfigTest {

  @Test
  void filterScan() {
    // Given
    ApplicationContext appConfig = new AnnotationConfigApplicationContext(
        ComponentsFilterAppConfig.class);

    // When
    BeanA beanA = appConfig.getBean("beanA", BeanA.class);

    // Then
    assertThat(beanA).isNotNull();
    assertThrows(Exception.class, () -> appConfig.getBean("beanB", BeanB.class));
  }

  @Configuration
  @ComponentScan(
      includeFilters = @ComponentScan.Filter(MyIncludeComponent.class),
      excludeFilters = @ComponentScan.Filter(MyExcludeComponent.class)
  )
  static class ComponentsFilterAppConfig {

  }
}
