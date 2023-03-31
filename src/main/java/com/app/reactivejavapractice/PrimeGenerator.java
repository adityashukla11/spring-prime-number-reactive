package com.app.reactivejavapractice;

import java.util.concurrent.Flow.*;

public class PrimeGenerator implements Publisher<Integer> {
  private int start, end;

  public PrimeGenerator(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void subscribe(Subscriber<? super Integer> subscriber) {
    //create a subscription
    Subscription subscription = new PrimeSubscription(subscriber, start, end);
    subscriber.onSubscribe(subscription);
  }
}
