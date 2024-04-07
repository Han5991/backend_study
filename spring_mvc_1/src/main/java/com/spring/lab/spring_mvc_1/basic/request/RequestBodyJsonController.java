package com.spring.lab.spring_mvc_1.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.lab.spring_mvc_1.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestBodyJsonController {

  private ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("/request-body-json-v1")
  public void requestBodyJsonV1(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    String messageBody = request.getReader().lines().reduce("", (acc, curr) -> acc + curr);
    log.info("messageBody={}", messageBody);
    HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
    response.getWriter().write("ok");
  }

  @ResponseBody
  @PostMapping("/request-body-json-v2")
  public String requestBodyJsonV2(
      @RequestBody String messageBody
  ) throws IOException {
    log.info("messageBody={}", messageBody);
    HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
    return "ok";
  }

  @ResponseBody
  @PostMapping("/request-body-json-v3")
  public String requestBodyJsonV3(@RequestBody HelloData helloData) {
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
    return "ok";
  }

  @ResponseBody
  @PostMapping("/request-body-json-v4")
  public String requestBodyJsonV4(HttpEntity<HelloData> helloData) {
    HelloData body = helloData.getBody();
    log.info("username={}, age={}", body.getUsername(), body.getAge());
    return "ok";
  }

  @ResponseBody
  @PostMapping("/request-body-json-v5")
  public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
    return helloData;
  }


}
