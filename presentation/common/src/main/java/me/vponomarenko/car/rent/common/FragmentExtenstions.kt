package me.vponomarenko.car.rent.common

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

fun Fragment.setTitle(@StringRes title: Int) {
    (requireActivity() as? AppCompatActivity)?.supportActionBar?.setTitle(title)
}

fun Fragment.enableToolbarBackButton(toolbar: Toolbar, clickAction: () -> Unit) {
    (requireActivity() as? AppCompatActivity)?.supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(true)
        setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            clickAction()
        }
    }
}

fun Fragment.disableToolbarBackButton(toolbar: Toolbar) {
    (requireActivity() as? AppCompatActivity)?.supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(false)
        setDisplayShowHomeEnabled(false)
        toolbar.setNavigationOnClickListener(null)
    }
}

fun Fragment.showToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
}