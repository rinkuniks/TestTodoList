package com.example.testtodolist.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.testtodolist.db.Category
import com.example.testtodolist.repository.TodoRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: TodoRepository) : ViewModel() {

    val allCategories: LiveData<List<Category>> = repository.getAllCategories()

    fun insertCategory(category: Category) = viewModelScope.launch {
        repository.insertCategory(category)
    }

    fun deleteCategory(category: Category) = viewModelScope.launch {
        repository.deleteCategory(category)
    }
}
