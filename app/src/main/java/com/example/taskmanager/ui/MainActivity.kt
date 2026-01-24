package com.example.taskmanager.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.data.Task

class MainActivity : AppCompatActivity() {

    // UI Components
    private lateinit var taskInput: TextInputEditText
    private lateinit var addButton: Button
    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var emptyStateText: TextView

    // ViewModel
    private lateinit var taskViewModel: TaskViewModel

    // Adapter
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ViewModel
        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        // Initialize views
        initViews()

        // Setup RecyclerView
        setupRecyclerView()

        // Setup listeners
        setupListeners()

        // Observe tasks from database
        observeTasks()
    }

    private fun initViews() {
        taskInput = findViewById(R.id.taskInput)
        addButton = findViewById(R.id.addButton)
        taskRecyclerView = findViewById(R.id.taskRecyclerView)
        emptyStateText = findViewById(R.id.emptyStateText)
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(
            tasks = tasks,
            onTaskToggle = { task ->
                handleTaskToggle(task)
            },
            onTaskDelete = { task ->
                handleTaskDelete(task)
            }
        )

        taskRecyclerView.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupListeners() {
        addButton.setOnClickListener {
            addTask()
        }

        // Also add task when "Done" is pressed on keyboard
        taskInput.setOnEditorActionListener { _, _, _ ->
            addTask()
            true
        }
    }

    private fun observeTasks() {
        taskViewModel.allTasks.observe(this) { taskList ->
            // Update adapter with new data from database
            tasks.clear()
            tasks.addAll(taskList)
            taskAdapter.notifyDataSetChanged()

            // Update empty state
            updateEmptyState()
        }
    }

    private fun addTask() {
        val taskTitle = taskInput.text.toString().trim()

        // Validation
        if (taskTitle.isEmpty()) {
            taskInput.error = "Task cannot be empty"
            return
        }

        // Create and insert task into database
        val newTask = Task(
            title = taskTitle,
            isCompleted = false
        )

        taskViewModel.insert(newTask)

        taskInput.text?.clear()
        taskInput.clearFocus()

        // Show confirmation
        Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
    }

    private fun handleTaskToggle(task: Task) {
        // Update task in database
        taskViewModel.update(task)

        val status = if (task.isCompleted) "completed" else "uncompleted"
        Toast.makeText(this, "Task marked as $status", Toast.LENGTH_SHORT).show()
    }

    private fun handleTaskDelete(task: Task) {
        // Delete from database
        taskViewModel.delete(task)

        Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show()
    }

    private fun updateEmptyState() {
        if (tasks.isEmpty()) {
            emptyStateText.visibility = View.VISIBLE
            taskRecyclerView.visibility = View.GONE
        } else {
            emptyStateText.visibility = View.GONE
            taskRecyclerView.visibility = View.VISIBLE
        }
    }
}