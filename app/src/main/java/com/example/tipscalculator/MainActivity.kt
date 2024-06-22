package com.example.tipscalculator

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_LONG

class MainActivity : AppCompatActivity() {

    // Total bill amount
    // Number of people
    // Tip percentage
    // 10%, 15% or 20%
    // Calculate
    // Clear

    // Layout View Recover
    // Find view by id
    // ViewBinding

    // Radio Buttons Recover
    // Tip Calculate
    // Show Results

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }


        binding.btnClean.setOnClickListener {
            binding.tieTotal.text
            binding.tieNumPeople.text
        }

        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true
            ) {
                Snackbar.make(binding.tieTotal, "Fill in all fields", Snackbar.LENGTH_LONG).show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total with tips: $totalWithTips"
            }
        }

        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tieNumPeople.setText("")
            binding.rbOptionThree.isChecked = false
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false

        }
    }
}


