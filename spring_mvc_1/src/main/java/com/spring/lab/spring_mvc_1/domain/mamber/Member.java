package com.spring.lab.spring_mvc_1.domain.mamber;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

  private Long id;
  private String username;
  private int age;

  public Member() {
  }

  public Member(String username, int age) {
    this.username = username;
    this.age = age;
  }
}