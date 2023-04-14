package com.example.practical

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.practical.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var courseCode: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.courseCodeSpinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.courses,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.courseCodeSpinner.adapter = adapter
        }


        binding.submitButton.setOnClickListener {
            submit()
        }

        binding.contactButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123"))

            startActivity(callIntent)
        }
    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        courseCode = parent.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        courseCode = "None"
    }

    private fun submit() {

        if (binding.editScore.text.toString() == "") {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            return
        }
        var score: Int = binding.editScore.text.toString().toInt()
        var grade: String

        when (score) {
            in 80..100 -> {
                grade = "A"
            }
            in 75..79 -> {
                grade = "A-"
            }
            in 70..74 -> {
                grade = "B+"
            }
            in 65..69 -> {
                grade = "B"
            }
            in 60..64 -> {
                grade = "B-"
            }
            in 55..59 -> {
                grade = "C+"
            }
            in 50..54 -> {
                grade = "C"
            }
            in 0..49 -> {
                grade = "D"
            }
            else -> {
                grade = "error"
            }
        }

        val student = Student(
            "Name = "+binding.editName.text.toString(),
            "Course Code = $courseCode",
            "Score = "+binding.editScore.text.toString(),
            "Grade = $grade",
        )
        binding.student = student
    }
}