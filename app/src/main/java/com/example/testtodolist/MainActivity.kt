package com.example.testtodolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtodolist.adaptors.CategoryAdapter
import com.example.testtodolist.databinding.ActivityMainBinding
import com.example.testtodolist.db.Category
import com.example.testtodolist.viewModels.CategoryViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categoryViewModel: CategoryViewModel by viewModels<CategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = categoryViewModel
        val adapter = CategoryAdapter { category ->
            // Handle category item click
            val intent = Intent(this, TodoItemActivity::class.java).apply {
                putExtra("CATEGORY_ID", category.id)
            }
            startActivity(intent)
        }

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter

        // Observe category data from ViewModel
        categoryViewModel.allCategories.observe(this) { categories ->
            categories?.let { adapter.submitList(it) }
        }
    }
}