package com.example.testtodolist.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtodolist.db.TodoItem
import com.example.testtodolist.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoItemViewModel(private val repository: TodoRepository) : ViewModel() {
    fun getItemsByCategoryId(categoryId: Int): LiveData<List<TodoItem>> = repository.getItemsByCategoryId(categoryId)

    fun insertTodoItem(todoItem: TodoItem) = viewModelScope.launch {
        repository.insertTodoItem(todoItem)
    }

    fun deleteTodoItem(todoItem: TodoItem) = viewModelScope.launch {
        repository.deleteTodoItem(todoItem)
    }

    fun updateTodoItemStatus(itemId: Int, isDone: Boolean) = viewModelScope.launch {
        repository.updateTodoItemStatus(itemId, isDone)
    }
}
