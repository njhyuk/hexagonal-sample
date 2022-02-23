package com.marketplace.product.api.common;

import com.marketplace.product.api.domain.exception.ApiThrottleException;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ApiThrottle {
  private final Bucket bucket;
  private final static Integer REQUEST_PER_MINUTE = 20;

  public ApiThrottle() {
    bucket = Bucket.builder()
        .addLimit(Bandwidth.classic(REQUEST_PER_MINUTE, Refill.greedy(REQUEST_PER_MINUTE, Duration.ofMinutes(1))))
        .build();
  }

  public boolean consume() {
    ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
    if (!probe.isConsumed()) {
      throw new ApiThrottleException();
    }
    return true;
  }
}
