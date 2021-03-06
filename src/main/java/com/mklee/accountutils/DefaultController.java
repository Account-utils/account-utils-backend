package com.mklee.accountutils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
  @Value("${message}")
  String env;

  @GetMapping("/")
  public String hello() {
    return env;
  }
}
