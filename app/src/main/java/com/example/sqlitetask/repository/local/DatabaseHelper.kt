package com.example.sqlitetask.repository.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION)  {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MemberDetails.db"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createMemberDetailsTable = "CREATE TABLE ${MemberDetailsContract.MemberEntry.TABLE_NAME} (" +
                "${MemberDetailsContract.MemberEntry.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${MemberDetailsContract.MemberEntry.COLUMN_NAME} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_MOBILE_NUMBER} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_ROLE} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_FEE} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_DEPOSIT_AMOUNT} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_LOAN_AMOUNT} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_GENDER} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_DOB} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_DOJ} TEXT," +
                "${MemberDetailsContract.MemberEntry.COLUMN_MARITAL_STATUS} TEXT,"+
                "${MemberDetailsContract.MemberEntry.COLUMN_DOM} TEXT, "+
                "${MemberDetailsContract.MemberEntry.COLUMN_CASTE} TEXT,"+
                "${MemberDetailsContract.MemberEntry.COLUMN_RELIGION} TEXT,"+
                "${MemberDetailsContract.MemberEntry.COLUMN_CATEGORY} TEXT,"+
                "${MemberDetailsContract.MemberEntry.COLUMN_AADHAR_NO} TEXT)"
        db?.execSQL(createMemberDetailsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${MemberDetailsContract.MemberEntry.TABLE_NAME}")
        onCreate(db)
    }
}