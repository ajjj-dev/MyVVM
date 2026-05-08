package com.aj.myvvm.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aj.myvvm.data.db.Items
import com.aj.myvvm.databinding.ActivityLocalListBinding
import com.aj.myvvm.ui.recyclerview.RowItemAdapter
import com.aj.myvvm.viewmodel.ItemsViewModel

class LocalListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocalListBinding
    private val viewModel: ItemsViewModel by viewModels()
    private lateinit var adapter: RowItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLocalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        observeItems()
        observeUsersFromApi()

        binding.button.setOnClickListener {
            viewModel.getUsers()
//            addClick()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun observeUsersFromApi() {
        Log.d("AJ12345", "users:")

        viewModel.usersData.observe(this) { users ->
            Log.d("AJ12345", "users size: " + users.users.size)
            val userNamesList = users.users.map { user ->
                Items(item = user.firstName)
            }
            adapter.submitList(userNamesList)
        }
    }

    private fun setUpRecyclerView() {
        adapter = RowItemAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun observeItems() {
        viewModel.allItems.observe(this) { items -> adapter.submitList(items) }
    }

    private fun addClick() {
        val item = binding.etItem.text.toString()
        if (item.isNotBlank()) {
            viewModel.insert(Items(item = item))
            binding.etItem.setText("")
        }
        observeItems()
    }
}