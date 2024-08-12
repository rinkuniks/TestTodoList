package com.example.testtodolist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtodolist.adaptors.TodoItemAdapter
import com.example.testtodolist.databinding.ActivityTodoItemBinding
import com.example.testtodolist.viewModels.TodoItemViewModel

class TodoItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoItemBinding
    private val todoItemViewModel: TodoItemViewModel by viewModels<TodoItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryId = intent.getIntExtra("CATEGORY_ID", -1)
        if (categoryId == -1) {
            // Handle error: no category ID passed
            finish()
            return
        }

        val adapter = TodoItemAdapter { todoItem ->
            // Handle item check/uncheck action
//            todoItemViewModel.updateTodoItemStatus(todoItem.id, !todoItem.isDone)
        }

        binding.todoItemRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todoItemRecyclerView.adapter = adapter

        // Observe todo items from ViewModel
        todoItemViewModel.getItemsByCategoryId(categoryId).observe(this) { todoItems ->
            todoItems?.let { adapter.submitList(it) }
        }
    }
}