package com.gdsdevtec.cineapp.utils

import android.content.Context
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.gdsdevtec.cineapp.R

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

fun Fragment.nextFragment(action : NavDirections){
    findNavController().navigate(action)
}
fun Fragment.initToolbar(toolbar: Toolbar,showIconNavigation : Boolean = true){
    (activity as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        title = ""
    }

    if (showIconNavigation){
        (activity as AppCompatActivity).supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.ic_back)
            setDisplayHomeAsUpEnabled(true)
        }
    }
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }

}