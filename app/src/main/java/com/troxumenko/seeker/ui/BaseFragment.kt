package com.troxumenko.seeker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.troxumenko.seeker.extentions.inflateVB

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    protected val bindingNullable: VB?
        get() = _binding

    protected abstract fun creatingBinding(parent: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = creatingBinding(container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        view?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it, null)
        }
        _binding = null
    }

    protected inline fun <reified T : ViewBinding> inflate(): T {
        return layoutInflater.inflateVB(null, null)
    }
}