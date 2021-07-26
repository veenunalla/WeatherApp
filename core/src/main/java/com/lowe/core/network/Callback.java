package com.lowe.core.network;

import androidx.annotation.NonNull;

public interface Callback<T> {

  Callback<?> IGNORE = new Callback<Object>() {
    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onFailure(@NonNull Throwable throwable) {

    }
  };

  @NonNull
  static <T> Callback<T> ignore() {
    //noinspection unchecked
    return (Callback<T>) IGNORE;
  }

  void onSuccess(T data);

  /**
   * {@link Callback#onSuccess(Object)} with additional info about time, when response was received
   */
  default void onSuccess(T data, long receivedResponseAtMillis) {
    onSuccess(data);
  }

  void onFailure(@NonNull Throwable throwable);
}
