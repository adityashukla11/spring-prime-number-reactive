package com.app.reactivejavapractice;

import static java.util.concurrent.Flow.Subscriber;
import static java.util.concurrent.Flow.Subscription;

public class PrintSubscriber implements Subscriber<Integer> {
  private Subscription subscription;
  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
//    subscription.request(3);
  }

  @Override
  public void onNext(Integer item) {
    System.out.println("Received item: " + item);
    subscription.request(1);
  }

  @Override
  public void onError(Throwable error) {
    System.out.println("Error occurred: " + error.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.println("PrintSubscriber is complete");
  }
}
