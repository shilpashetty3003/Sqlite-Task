package com.example.sqlitetask.ui

import android.annotation.SuppressLint
import android.app.Application
import android.database.Cursor
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sqlitetask.model.Member
import com.example.sqlitetask.repository.DBRepository

class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var dbRepository: DBRepository? = null

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext


    val cursor = MutableLiveData<Cursor?>()

    init {
        dbRepository = DBRepository(context)
        dbRepository!!.open()
        fetch()
    }

    fun insert(member: Member) {
        dbRepository!!.insert(member)
        fetch()
    }

    fun fetch() {
        cursor.value = dbRepository?.fetch()
    }

}