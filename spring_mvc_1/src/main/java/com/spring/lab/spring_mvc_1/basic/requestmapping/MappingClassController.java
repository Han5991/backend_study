package com.spring.lab.spring_mvc_1.basic.requestmapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

  @GetMapping
  public String user() {
    return "user";
  }

  @PostMapping
  public String addUser() {
    return "addUser";
  }

  @GetMapping("/{userId}")
  public String findUser(@PathVariable String userId) {
    return "findUser userId = " + userId;
  }

  @PatchMapping("/{userId}")
  public String updateUser(@PathVariable String userId) {
    return "updateUser userId = " + userId;
  }

  @DeleteMapping("{userId}")
  public String deleteUser(@PathVariable String userId) {
    return "deleteUser userId = " + userId;
  }

}
