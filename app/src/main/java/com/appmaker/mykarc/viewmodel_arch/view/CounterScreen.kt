package com.appmaker.mykarc.viewmodel_arch.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.appmaker.mykarc.databinding.ActivityCounterScreenBinding
import com.appmaker.mykarc.viewmodel_arch.view_model.CounterViewModel

class CounterScreen : AppCompatActivity() {
    private val TAG: String = "MyTag"
    private val binding: ActivityCounterScreenBinding by lazy {
        ActivityCounterScreenBinding.inflate(layoutInflater)
    }


    lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        Log.d(TAG, "onCreate: counterViewModel" + counterViewModel)
        setText()
        binding.button.setOnClickListener {
            counterViewModel.increment()
            setText()
        }


    }

    private fun setText() {
        binding.textView.text = counterViewModel.count.toString()

    }
}