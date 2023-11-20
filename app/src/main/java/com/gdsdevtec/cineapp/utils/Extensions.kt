package com.gdsdevtec.cineapp.utils

import android.content.Context
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.messageToast(msg: String) = Toast.makeText(
    requireContext(), msg, Toast.LENGTH_SHORT
).show()

fun Fragment.hideKeyboard() {
    val view = activity?.currentFocus
    if (view != null) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }
}

fun String.isEmailValid(): Boolean {
    val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    return emailPattern.matches(this) && Patterns.EMAIL_ADDRESS.matcher(this)
        .matches()
}

fun String.isPasswordValid(): Boolean {
    return this.length >= 6
}