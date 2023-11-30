package com.example.sqlitetask.ui

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sqlitetask.R
import com.example.sqlitetask.databinding.FragmentAddBinding
import com.example.sqlitetask.model.Member
import java.util.*


class AddFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentAddBinding
    var mYear: Int = 0
    var mMonth: Int = 0
    var mDay: Int = 0
    var selectRole: String = ""
    var gender: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDOB.setOnClickListener(this)
        binding.btnDOJ.setOnClickListener(this)
        binding.btnDOM.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
        binding.selectRole.setOnCheckedChangeListener { group, checkedId ->
            Log.d("TAG", "addData: $checkedId ")
            when (checkedId) {
                R.id.rbSecreatary -> {
                    selectRole = "Secreatory"
                }
                R.id.rbMember -> {
                    selectRole = "Member"
                }
            }
        }
        binding.gender.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbMale -> {
                    gender = "Male"
                }
                R.id.rbFemale -> {
                    gender = "Female"
                }
                R.id.rbOther -> {
                    gender = "Other"
                }
            }

        }

    }

    fun addData() {


        val model = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)
        model.insert(member = Member(
            name = binding.edName.text.toString(),
            phone_number = binding.edPhoneNumber.text.toString(),
            role = selectRole,
            fee = binding.edSubscriptionFee.text.toString(),
            deposit_amount = binding.edDepositAmount.text.toString(),
            loan_amount = binding.edLoanAmount.text.toString(),
            dob = binding.edDOB.text.toString(),
            doj = binding.edDOJ.text.toString(),
            status = "",
            dom = binding.edDOM.text.toString(),
            caste = binding.edCaste.text.toString(),
            religion = binding.edReligion.text.toString(),
            category = binding.edCategory.text.toString(),
            aadharNo = binding.edAadharNo.text.toString(),
            gender = gender
        ))

    }


    override fun onClick(view: View) {

        val c: Calendar = Calendar.getInstance()
        mYear = c.get(Calendar.YEAR)
        mMonth = c.get(Calendar.MONTH)
        mDay = c.get(Calendar.DAY_OF_MONTH)
        if (view == binding.btnDOB) {
            val datePickerDialog = DatePickerDialog(requireActivity(),
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.edDOB.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                }, mYear, mMonth, mDay)
            datePickerDialog.show()
        }
        if (view == binding.btnDOJ) {
            val datePickerDialog = DatePickerDialog(requireContext(),
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.edDOJ.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                }, mYear, mMonth, mDay)
            datePickerDialog.show()
        }
        if (view == binding.btnDOM) {

            val datePickerDialog = DatePickerDialog(requireContext(),
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    binding.edDOM.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                }, mYear, mMonth, mDay)
            datePickerDialog.show()

        }
        if (view == binding.btnSubmit) {

            if (binding.edName.text.toString() == "") {
                binding.edName.setError("Enter Name")
            } else if (binding.edPhoneNumber.text.toString() == "") {
                binding.edPhoneNumber.setError("Enter Phone Number")
            } else if (selectRole == "") {
                showMessage("Select Role")
            } else if (gender == "") {

                showMessage("Select Gender")
            } else {
                addData()
                showMessage("Member Added Successfully")

                val fm = fragmentManager
                fm?.popBackStack()

            }


        }

    }

    fun showMessage(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT)
            .show()
    }


}