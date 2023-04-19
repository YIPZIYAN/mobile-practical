package com.example.practical

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practical.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var code: String
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.codeSpinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.code,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.codeSpinner.adapter = adapter
        }
        binding.student = viewModel.getCurrentResult()

        binding.submitBtn.setOnClickListener {
            submit()
        }

        binding.phoneBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789")))
        }

        binding.emailBtn.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                putExtra(Intent.EXTRA_EMAIL, "kun@gmail.com")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    private fun submit() {

        val score = binding.editScore.text.toString().toInt()
        viewModel.getResult(
            Student(
                binding.editName.text.toString(),
                code,
                binding.editScore.text.toString(),
            )
        )
        binding.student = viewModel.getCurrentResult()
    }

    override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
        code = p0.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        code = ""
    }
}