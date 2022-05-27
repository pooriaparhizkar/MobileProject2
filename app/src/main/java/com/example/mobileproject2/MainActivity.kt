package com.example.mobileproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.mobileproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding?=null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.sleep(3000)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            ad d<HomeFragment>(R.id.fragment_container_view)
        }
    }
}