package com.example.testtodolist.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtodolist.databinding.ItemsListBinding
import com.example.testtodolist.db.TodoItem

class TodoItemAdapter(private val onItemCheckedChange: (TodoItem) -> Unit) :
    ListAdapter<TodoItem, TodoItemAdapter.TodoItemViewHolder>(TodoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val binding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val todoItem = getItem(position)
        holder.bind(todoItem)
        holder.itemView.setOnClickListener {
            todoItem.isDone = !todoItem.isDone
            onItemCheckedChange(todoItem)
            notifyItemChanged(position)
        }
    }

    class TodoItemViewHolder(private val binding: ItemsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todoItem: TodoItem) {
            binding.todoDescription.text = todoItem.description
            binding.checkbox.isChecked = todoItem.isDone
        }
    }
}

class TodoItemDiffCallback : DiffUtil.ItemCallback<TodoItem>() {
    override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem == newItem
    }
}
