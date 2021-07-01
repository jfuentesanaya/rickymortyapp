package com.jfuentes.rickymortyapp.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jfuentes.rickymortyapp.R
import com.jfuentes.rickymortyapp.databinding.ActivityListBinding
import com.jfuentes.rickymortyapp.presentation.viewmodel.ListVM
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListActivity : AppCompatActivity() {

    private val listVM by viewModel<ListVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.model = listVM
    }


    companion object {
        @JvmStatic
        fun getCallingIntent(context: Context)  = Intent(context, ListActivity::class.java)
    }
}