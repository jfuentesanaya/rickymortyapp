package com.jfuentes.rickymortyapp.presentation.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jfuentes.rickymortyapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil
import com.jfuentes.rickymortyapp.databinding.ActivityListBinding
import com.jfuentes.rickymortyapp.presentation.viewmodel.ListVM


class ListActivity : AppCompatActivity() {

    private val listVM by viewModel<ListVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val binding: ActivityListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_list)

        binding.model = listVM
    }


    companion object {
        @JvmStatic
        fun getCallingIntent(context: Context)  = Intent(context, ListActivity::class.java)
    }
}