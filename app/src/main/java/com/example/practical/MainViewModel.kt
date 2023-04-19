package com.example.practical

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var result = Student()

    fun getCurrentResult():Student{
        return result
    }

    fun getResult(student: Student) {
        when (student.score.toInt()) {
            in 80..100 -> {
                student.grade = "A"
            }
            in 75..79 -> {
                student.grade = "A-"
            }
            in 70..74 -> {
                student.grade = "B+"
            }
            in 65..69 -> {
                student.grade = "B"
            }
            in 60..64 -> {
                student.grade = "B-"
            }
            in 55..59 -> {
                student.grade = "C+"
            }
            in 50..54 -> {
                student.grade = "C"
            }
            in 0..49 -> {
                student.grade = "D"
            }
            else -> {
                student.grade = "error"
            }
        }
        result = student
    }

}