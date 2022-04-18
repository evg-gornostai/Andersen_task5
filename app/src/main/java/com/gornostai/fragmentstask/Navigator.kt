package com.gornostai.fragmentstask

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator{
    return requireActivity() as Navigator
}

interface Navigator {

    fun launchDetailsFragment(id: Int, name: String, surname: String, phone: String)

    fun launchContactsFragment(id: Int, name: String, surname: String, phone: String)

}