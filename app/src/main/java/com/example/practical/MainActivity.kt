package com.example.practical

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.practical.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    var student = Student()
    lateinit var code: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.student = student
        binding.codeSpinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.code,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.codeSpinner.adapter = adapter
        }

        binding.phoneBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:012345677")))
        }

        binding.emailBtn.setOnClickListener {
            val web = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"))
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL,arrayOf("kun@mail.com"))
                putExtra(Intent.EXTRA_TEXT,"1996")
                type = "text/plain"
            }
            startActivity(web)

        }
    }

    override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
        code = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        code = ""
    }
}