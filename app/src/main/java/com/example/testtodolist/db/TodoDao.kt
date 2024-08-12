package com.example.testtodolist.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    // Categories
    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    // Todo Items
    @Query("SELECT * FROM todo_items WHERE categoryId = :categoryId")
    fun getItemsByCategoryId(categoryId: Int): LiveData<List<TodoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoItem(todoItem: TodoItem)

    @Delete
    suspend fun deleteTodoItem(todoItem: TodoItem)

    @Query("UPDATE todo_items SET isDone = :isDone WHERE id = :itemId")
    suspend fun updateTodoItemStatus(itemId: Int, isDone: Boolean)
}
