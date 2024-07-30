package com.example.assignment2_1216690

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class PhoneDetailsFragment : Fragment() {

    companion object {
        val phoneList = mutableListOf<Phone>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_phone_details, container, false)

        val spinnerPhoneModel: Spinner = view.findViewById(R.id.spinner_phone_model)
        val editTextPhoneName: EditText = view.findViewById(R.id.edit_text_phone_name)
        val radioGroupOperatingSystem: RadioGroup = view.findViewById(R.id.radio_group_operating_system)
        val buttonSubmit: Button = view.findViewById(R.id.button_submit)
        val textViewPhoneDetails: TextView = view.findViewById(R.id.text_view_phone_details)

        buttonSubmit.setOnClickListener {
            val phoneModel = spinnerPhoneModel.selectedItem.toString()
            val phoneName = editTextPhoneName.text.toString()
            val selectedOperatingSystemId = radioGroupOperatingSystem.checkedRadioButtonId
            val operatingSystem = if (selectedOperatingSystemId != -1) {
                view.findViewById<RadioButton>(selectedOperatingSystemId).text.toString()
            } else {
                "Not selected"
            }

            if (phoneName.isNotEmpty() && selectedOperatingSystemId != -1) {
                val phone = Phone(phoneModel, phoneName, operatingSystem)
                phoneList.add(phone)

                val phoneDetails = "Phone Model: $phoneModel\nPhone Name: $phoneName\nOperating System: $operatingSystem"
                textViewPhoneDetails.text = phoneDetails
                textViewPhoneDetails.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}