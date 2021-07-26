package com.lowe.weatherapp.di;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import dagger.Binds;
import dagger.Module;

/**
 * Dagger's module that provides base dependencies that can be used by app.
 */
@Module
public interface LoweAppModule {

  @Binds
  @NonNull
  Context bindContext(@NonNull final Application application);
}
