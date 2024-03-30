package com.spring.lab.spring_basic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        PrototypeBean.class);
    PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
    prototypeBean1.addCount();

    PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
    prototypeBean2.addCount();

    assertThat(prototypeBean1.getCount()).isEqualTo(1);
    assertThat(prototypeBean2.getCount()).isEqualTo(1);
  }

  @Test
  void singleClientUseProtoType() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ClientBean.class, PrototypeBean.class);
    ClientBean clientBean1 = context.getBean(ClientBean.class);
    int logic = clientBean1.logic();

    assertThat(logic).isEqualTo(1);
    ClientBean clientBean2 = context.getBean(ClientBean.class);
    int logic1 = clientBean2.logic();
    assertThat(logic1).isEqualTo(1);
  }

  @Scope
  static class ClientBean {

    @Autowired
    private Provider<PrototypeBean> provider;

    public int logic() {
      PrototypeBean providerObject = provider.get(); // getObject 프로토 타입을 찾아주는 매서드
      providerObject.addCount();
      return providerObject.getCount();
    }
  }

  @Scope("prototype")
  static class PrototypeBean {

    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init " + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }
}
