package com.marketplace.product.api.common;

import com.marketplace.product.api.common.ApiThrottleInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  private final ApiThrottleInterceptor apiThrottleInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(apiThrottleInterceptor).addPathPatterns("/**");
  }
}
