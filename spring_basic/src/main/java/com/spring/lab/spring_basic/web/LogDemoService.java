package com.spring.lab.spring_basic.web;

import com.spring.lab.spring_basic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
  private final ObjectProvider<MyLogger> myLoggerProvider;

  public void logic(String testId) {
    MyLogger myLogger = myLoggerProvider.getObject();
    myLogger.log("service id = " + testId);
  }
}
