package com.example.testtodolist.db
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val description: String,
    var isDone: Boolean = false
)
