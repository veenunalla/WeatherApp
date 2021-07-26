package com.lowe.core.network;

import androidx.annotation.NonNull;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class ServiceFactory {

  @NonNull
  private final Converter.Factory factory;
  @NonNull
  private final OkHttpClient okHttpClient;

  @Inject ServiceFactory(@NonNull Converter.Factory factory, @NonNull OkHttpClient okHttpClient) {
    this.factory = factory;
    this.okHttpClient = okHttpClient;
  }

  @NonNull
  public <T> T create(@NonNull final String baseUrl, @NonNull final Class<T> serviceClass) {
    return create(baseUrl, okHttpClient, serviceClass);
  }

  @NonNull
  public <T> T create(@NonNull final String baseUrl,
      @NonNull final OkHttpClient okHttpClient,
      @NonNull final Class<T> serviceClass) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(factory)
        .client(okHttpClient)
        .build()
        .create(serviceClass);
  }
}
