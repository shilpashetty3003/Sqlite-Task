package com.example.sqlitetask.ui

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitetask.R
import com.example.sqlitetask.model.Member
import com.example.sqlitetask.repository.local.MemberDetailsContract

class MemberAdapter(private val context: Context, private val cursor: Cursor?) :RecyclerView.Adapter<MemberAdapter.MemberDetailsViewHolder> (){

    inner class MemberDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val mobileTextView: TextView = itemView.findViewById(R.id.tvMobileNo)
        private val memberTextView: TextView = itemView.findViewById(R.id.tvMemberRole)
        fun bind(userDetails: Member) {
            nameTextView.text = userDetails.name
            mobileTextView.text = userDetails.phone_number
            memberTextView.text = userDetails.role

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberDetailsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_member_card, parent, false)
        return MemberDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberDetailsViewHolder, position: Int) {
        cursor?.moveToPosition(position)
        val userDetails = getUserDetailsFromCursor(cursor)
        holder.bind(userDetails)
    }

    override fun getItemCount(): Int {
        return cursor?.count ?: 0
    }


    private fun getUserDetailsFromCursor(cursor: Cursor?): Member {
        cursor?.apply {
            val name = getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_NAME))
            val mobile =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_MOBILE_NUMBER))
            val role = getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_ROLE))
            val fee = getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_FEE))
            val amount =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_DEPOSIT_AMOUNT))
            val loanAmount =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_LOAN_AMOUNT))
            val gender =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_GENDER))
            val dob = getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_DOB))
            val doj = getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_DOJ))
            val aadharNo =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_AADHAR_NO))
            val caste =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_CASTE))
            val religion =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_RELIGION))
            val category =
                getString(getColumnIndexOrThrow(MemberDetailsContract.MemberEntry.COLUMN_CATEGORY))



            return Member(
               name=name,
                phone_number = mobile,
                role=role,
                fee =fee,
                deposit_amount = amount,
                loan_amount = loanAmount,
                gender=gender,
                dob = dob,
                doj = doj,
                status ="" ,
                dom ="",
                caste ="",
                religion ="",
                category ="",
                aadharNo =""
            )
        }
        throw IllegalArgumentException("Cursor is null or empty!")
    }

}