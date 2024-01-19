package com.novelitech.intentservicekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.novelitech.intentservicekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvMessage.text = "Service running"
            }
        }

        binding.btnStop.setOnClickListener {
            MyIntentService.stopService()
            binding.tvMessage.text = "Service stopped"
        }
    }
}