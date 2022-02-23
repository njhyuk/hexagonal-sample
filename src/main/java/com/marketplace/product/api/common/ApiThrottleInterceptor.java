package com.marketplace.product.api.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class ApiThrottleInterceptor implements HandlerInterceptor {
  private final ApiThrottle apiThrottle;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    return apiThrottle.consume();
  }
}
