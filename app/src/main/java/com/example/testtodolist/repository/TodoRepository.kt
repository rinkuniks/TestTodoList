package com.example.testtodolist.repository

import androidx.lifecycle.LiveData
import com.example.testtodolist.db.Category
import com.example.testtodolist.db.TodoDao
import com.example.testtodolist.db.TodoItem

class TodoRepository(private val todoDao: TodoDao) {
    fun getAllCategories(): LiveData<List<Category>> = todoDao.getAllCategories()

    suspend fun insertCategory(category: Category) = todoDao.insertCategory(category)

    suspend fun deleteCategory(category: Category) = todoDao.deleteCategory(category)

    fun getItemsByCategoryId(categoryId: Int): LiveData<List<TodoItem>> = todoDao.getItemsByCategoryId(categoryId)

    suspend fun insertTodoItem(todoItem: TodoItem) = todoDao.insertTodoItem(todoItem)

    suspend fun deleteTodoItem(todoItem: TodoItem) = todoDao.deleteTodoItem(todoItem)

    suspend fun updateTodoItemStatus(itemId: Int, isDone: Boolean) = todoDao.updateTodoItemStatus(itemId, isDone)
}
