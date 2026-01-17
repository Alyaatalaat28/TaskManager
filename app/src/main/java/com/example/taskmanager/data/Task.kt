package com.example.taskmanager.data

data class Task(
    val id: Int,
    val title: String,
    var isCompleted: Boolean = false
)