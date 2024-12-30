package com.antonio.course.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayHello(String person, String phrase) {
    return String.format("Hello %s, %s", person, phrase);
  }

}
