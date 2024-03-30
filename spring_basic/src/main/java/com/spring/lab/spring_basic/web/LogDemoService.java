package com.spring.lab.spring_basic.web;

import com.spring.lab.spring_basic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final MyLogger myLogger;

  public void logic(String testId) {
    myLogger.log("service id = " + testId);
  }
}
