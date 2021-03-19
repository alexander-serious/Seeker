package com.troxumenko.seeker.extentions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> LayoutInflater.inflateVB(
    parent: ViewGroup?,
    attachToParent: Boolean?
): T {
    return when {
        parent == null -> {
            val method = T::class.java.getMethod("inflate", LayoutInflater::class.java)
            method.invoke(null, this) as T
        }

        attachToParent == null -> {
            val method = T::class.java.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java
            )
            method.invoke(null, this, parent) as T
        }

        else -> {
            val method = T::class.java.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
            method.invoke(null, this, parent, attachToParent) as T
        }
    }
}