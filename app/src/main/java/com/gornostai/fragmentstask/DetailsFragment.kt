package com.gornostai.fragmentstask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gornostai.fragmentstask.databinding.FragmentDetailsBinding

private const val ARG_CONTACT = "contact"
private const val ARG_NAME = "name"
private const val ARG_SURNAME = "surname"
private const val ARG_PHONE= "phone"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private var id: Int? = null
    private var name: String? = null
    private var surname: String? = null
    private var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_CONTACT)
            name = it.getString(ARG_NAME)
            surname = it.getString(ARG_SURNAME)
            phone = it.getString(ARG_PHONE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.tvHeader.text = requireContext().getString(R.string.contacts_header)
            .replace("[CONTACT_NAME]", name ?: "")
        binding.edName.setText(name)
        binding.edSurname.setText(surname)
        binding.edPhoneNumber.setText(phone)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            navigator().launchContactsFragment(
                id = id ?: 1 ,
                name = binding.edName.text.toString(),
                surname = binding.edSurname.text.toString(),
                phone = binding.edPhoneNumber.text.toString())
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int, name: String, surname: String, phone: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CONTACT, id)
                    putString(ARG_NAME, name)
                    putString(ARG_SURNAME, surname)
                    putString(ARG_PHONE, phone)
                }
            }
    }
}