package com.app.reactivejavapractice;
import java.util.concurrent.Flow.*;

public class PrimeSubscriber implements Subscriber<Integer> {

  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    this.subscription.request(2); // Request 10 prime numbers at a time
  }

  @Override
  public void onNext(Integer prime) {
    System.out.println("ITEM RECEIVED" + prime);
    this.subscription.request(1); // Request the next prime number
  }

  @Override
  public void onError(Throwable throwable) {
    throwable.printStackTrace();
  }

  @Override
  public void onComplete() {
    System.out.println("Done");
  }

}

