package com.example.rebootapp.presentation.base

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.rebootapp.R
import com.example.rebootapp.databinding.ActivityMainBinding
import com.example.rebootapp.utils.receiver.scheduleJob

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.setGraph(
            R.navigation.nav_graph,
            null
        )
        // TODO Ask for permission to notify
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}