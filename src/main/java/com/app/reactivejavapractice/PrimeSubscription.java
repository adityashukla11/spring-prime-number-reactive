package com.app.reactivejavapractice;

import java.util.concurrent.Flow.*;

public class PrimeSubscription implements Subscription {

  private Subscriber<? super Integer> subscriber;
  private int current, end;
  private boolean cancelled;

  public PrimeSubscription(Subscriber<? super Integer> subscriber, int start, int end) {
    this.subscriber = subscriber;
    this.current = Math.max(start, 2);
    this.end = end;
  }

  @Override
  public void request(long n) {
    for (int i = 0; i < n && current <= end && !cancelled; i++) {
      while(!isPrime(current)){
        current++;
      }
      if (current >= end || cancelled) {
        subscriber.onComplete();
        return;
      }
      subscriber.onNext(current++);
    }
  }

  private boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void cancel() {
    cancelled = true;
  }
}
