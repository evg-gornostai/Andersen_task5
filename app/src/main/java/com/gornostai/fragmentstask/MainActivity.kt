package com.gornostai.fragmentstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.mainFragmentContainer, ContactsFragment())
            .commit()

    }

    override fun launchDetailsFragment(id: Int, name: String, surname: String, phone: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.mainFragmentContainer, DetailsFragment.newInstance(id = id, name = name, surname = surname, phone = phone))
            .commit()
    }

    override fun launchContactsFragment(id: Int, name: String, surname: String, phone: String) {
        val fm = supportFragmentManager
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        fm.beginTransaction()
            .replace(R.id.mainFragmentContainer, ContactsFragment.newInstance(id = id, name = name, surname = surname, phone = phone))
            .commit()
    }
}