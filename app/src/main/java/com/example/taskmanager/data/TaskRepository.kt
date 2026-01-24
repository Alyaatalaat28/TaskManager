package com.example.taskmanager.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task): Long {
        return taskDao.insert(task)
    }

    suspend fun update(task: Task) {
        taskDao.update(task)
    }

    suspend fun delete(task: Task) {
        taskDao.delete(task)
    }

    suspend fun getTaskById(taskId: Int): Task? {
        return taskDao.getTaskById(taskId)
    }

    suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }

    fun getTasksByStatus(completed: Boolean): LiveData<List<Task>> {
        return taskDao.getTasksByStatus(completed)
    }
}