package com.example.sqlitetask.repository.local

import android.provider.BaseColumns

object MemberDetailsContract {
    class MemberEntry :BaseColumns{
        companion object{
            const val TABLE_NAME = "member_details"
            const val COLUMN_NAME = "name"
            const val COLUMN_ID = "id"
            const val COLUMN_MOBILE_NUMBER = "mobile_number"
            const val COLUMN_ROLE = "role"
            const val COLUMN_FEE = "fee"
            const val COLUMN_DEPOSIT_AMOUNT = "deposit_amount"
            const val COLUMN_LOAN_AMOUNT = "loan_amount"
            const val COLUMN_GENDER = "gender"
            const val COLUMN_DOB = "dob"
            const val COLUMN_DOJ = "doj"
            const val COLUMN_MARITAL_STATUS = "status"
            const val COLUMN_DOM = "dom"
            const val COLUMN_CASTE = "caste"
            const val COLUMN_RELIGION = "religion"
            const val COLUMN_CATEGORY = "category"
            const val COLUMN_AADHAR_NO = "aadhar_no"


        }
    }
}