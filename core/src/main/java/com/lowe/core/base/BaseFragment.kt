package com.lowe.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<B: ViewDataBinding, V: ViewModel>: DaggerFragment() {

  @Inject
  lateinit var viewModelFactory: Factory


  protected lateinit var viewModel: V

  protected lateinit var binding: B

  protected abstract val layoutId: Int

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    binding.lifecycleOwner = viewLifecycleOwner
    return binding.root
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = obtainViewModel()
  }

  abstract fun obtainViewModel(): V
}