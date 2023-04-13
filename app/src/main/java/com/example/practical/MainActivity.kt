package com.example.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerSelection : Spinner = findViewById(R.id.spinner)
        spinnerSelection.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.course_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinnerSelection.adapter = adapter
        }
    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val selectionTv : TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text = parent.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>){
        val selectionTv : TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text = "You have not make a course selection"
    }

}