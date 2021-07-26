package com.lowe.core;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public interface ViewModelModule {

  @Binds
  @NonNull
  ViewModelProvider.Factory bindFactory(@NonNull final ViewModelFactory factory);
}
