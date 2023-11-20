package com.gdsdevtec.cineapp.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.messageToast(msg: String) = Toast.makeText(
    requireContext(), msg, Toast.LENGTH_SHORT
).show()