package com.example.taskmanager.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.R
import com.example.taskmanager.data.Task

class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onTaskToggle: (Task) -> Unit,
    private val onTaskDelete: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.taskTitle)
        val taskId: TextView = itemView.findViewById(R.id.taskId)
        val taskCheckbox: CheckBox = itemView.findViewById(R.id.taskCheckbox)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        // Set task data
        holder.taskTitle.text = task.title
        holder.taskId.text = "ID: ${task.id}"
        holder.taskCheckbox.isChecked = task.isCompleted

        // Apply strikethrough if completed
        if (task.isCompleted) {
            holder.taskTitle.paintFlags = holder.taskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.taskTitle.paintFlags = holder.taskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        // Checkbox listener
        holder.taskCheckbox.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked
            onTaskToggle(task)

            // Update strikethrough
            if (isChecked) {
                holder.taskTitle.paintFlags = holder.taskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.taskTitle.paintFlags = holder.taskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }

        // Delete button listener
        holder.deleteButton.setOnClickListener {
            onTaskDelete(task)
        }
    }

    override fun getItemCount(): Int = tasks.size

    // Helper method to add task
    fun addTask(task: Task) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    // Helper method to remove task
    fun removeTask(task: Task) {
        val position = tasks.indexOf(task)
        if (position != -1) {
            tasks.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}