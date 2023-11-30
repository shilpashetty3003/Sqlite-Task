package com.example.sqlitetask.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.sqlitetask.model.Member
import com.example.sqlitetask.repository.local.DatabaseHelper
import com.example.sqlitetask.repository.local.MemberDetailsContract
import java.sql.SQLException


class DBRepository(var context: Context?) {

    private var dbHelper: DatabaseHelper? = null

    private var database: SQLiteDatabase? = null

    @Throws(SQLException::class)
    fun open(): DBRepository? {
        dbHelper = DatabaseHelper(context!!)
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper!!.close()
    }

    fun insert(member: Member) {
        val contentValue = ContentValues()
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_NAME, member.name)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_MOBILE_NUMBER, member.name)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_ROLE, member.role)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_FEE, member.fee)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_DEPOSIT_AMOUNT, member.deposit_amount)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_LOAN_AMOUNT, member.loan_amount)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_GENDER, member.gender)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_DOB, member.dob)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_DOJ, member.doj)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_MARITAL_STATUS, member.status)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_DOM, member.dom)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_CASTE, member.caste)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_RELIGION, member.religion)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_CATEGORY, member.category)
        contentValue.put(MemberDetailsContract.MemberEntry.COLUMN_AADHAR_NO, member.aadharNo)
        database!!.insert(MemberDetailsContract.MemberEntry.TABLE_NAME, null, contentValue)

    }

    fun fetch(): Cursor? {
        val cursor = database?.rawQuery("SELECT * FROM ${MemberDetailsContract.MemberEntry.TABLE_NAME}", null)
        return cursor
    }

//    fun update(_id: Long, name: String?, desc: String?): Int {
//        val contentValues = ContentValues()
//        contentValues.put(DatabaseHelper.SUBJECT, name)
//        contentValues.put(DatabaseHelper.DESC, desc)
//        return database!!.update(DatabaseHelper.TABLE_NAME,
//            contentValues,
//            DatabaseHelper._ID + " = " + _id,
//            null)
//    }
//
//    fun delete(_id: Long) {
//        database!!.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null)
//    }

}