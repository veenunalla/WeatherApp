package com.lowe.core.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Extension function to provide view model scoped to this [Fragment] by default.
 *
 * @param factory provider factory that is responsible to instantiate ViewModel.
 * @param owner a scope that owns created ViewModel.
 */
inline fun <reified T : ViewModel> Fragment.provideViewModel(
  factory: ViewModelProvider.Factory,
  owner: ViewModelStoreOwner = this
): T {
  return ViewModelProvider(owner, factory)[T::class.java]
}

val FragmentManager.currentNavigationFragment: Fragment?
  get() = primaryNavigationFragment?.childFragmentManager?.fragments?.first()