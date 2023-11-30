package com.example.sqlitetask.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import com.example.sqlitetask.R
import com.example.sqlitetask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment())
            .commit()

        setContentView(binding.root)
    }
}
