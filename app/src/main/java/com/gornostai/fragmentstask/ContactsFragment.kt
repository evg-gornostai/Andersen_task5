package com.gornostai.fragmentstask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gornostai.fragmentstask.databinding.FragmentContactsBinding

private const val ARG_CONTACT = "contact"
private const val ARG_NAME = "name"
private const val ARG_SURNAME = "surname"
private const val ARG_PHONE= "phone"

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)

        arguments?.let {
            when (it.getInt(ARG_CONTACT)) {
                1 -> {
                    binding.tvName1.text = it.getString(ARG_NAME)
                    binding.tvSurname1.text = it.getString(ARG_SURNAME)
                    binding.tvPhoneNumber1.text = it.getString(ARG_PHONE)
                }
                2 -> {
                    binding.tvName2.text = it.getString(ARG_NAME)
                    binding.tvSurname2.text = it.getString(ARG_SURNAME)
                    binding.tvPhoneNumber2.text = it.getString(ARG_PHONE)
                }
                3 -> {
                    binding.tvName3.text = it.getString(ARG_NAME)
                    binding.tvSurname3.text = it.getString(ARG_SURNAME)
                    binding.tvPhoneNumber3.text = it.getString(ARG_PHONE)
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.contact1.setOnClickListener {
            navigator().launchDetailsFragment(
                id = 1,
                name = binding.tvName1.text.toString(),
                surname = binding.tvSurname1.text.toString(),
                phone = binding.tvPhoneNumber1.text.toString()
                )
        }

        binding.contact2.setOnClickListener {
            navigator().launchDetailsFragment(
                id = 2,
                name = binding.tvName2.text.toString(),
                surname = binding.tvSurname2.text.toString(),
                phone = binding.tvPhoneNumber2.text.toString()
            )
        }

        binding.contact3.setOnClickListener {
            navigator().launchDetailsFragment(
                id = 3,
                name = binding.tvName3.text.toString(),
                surname = binding.tvSurname3.text.toString(),
                phone = binding.tvPhoneNumber3.text.toString()
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, name: String, surname: String, phone: String) =
            ContactsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CONTACT, id)
                    putString(ARG_NAME, name)
                    putString(ARG_SURNAME, surname)
                    putString(ARG_PHONE, phone)
                }
            }
    }

}