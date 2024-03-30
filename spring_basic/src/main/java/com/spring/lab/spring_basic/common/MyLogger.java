package com.spring.lab.spring_basic.common;

import static java.util.UUID.randomUUID;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
@Setter
public class MyLogger {

  private String uuid;
  private String requestURL;

  public void log(String message) {
    System.out.println("[" + uuid + "][" + requestURL + "] " + message);
  }

  @PostConstruct
  public void init() {
    uuid = randomUUID().toString();
    System.out.println("[" + uuid + "] request scope bean create: " + this);
  }

  @PreDestroy
  public void close() {
    System.out.println("[" + uuid + "] request scope close");
  }

}
