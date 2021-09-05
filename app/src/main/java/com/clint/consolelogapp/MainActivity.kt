package com.clint.consolelogapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clint.consolelogapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.e("testing", "testing")

        binding.textViewAdd.setOnClickListener {
            getSumOfTwoNumbers()
        }

        binding.textViewMultiplication.setOnClickListener {
            getMultiplicationOfTwoNumbers()
        }
        binding.textViewDivision.setOnClickListener {
            getDivisionOfTwoNumbers()
        }
    }

    private fun getDivisionOfTwoNumbers() {
        val numberOne = binding.editTextDivisionOne.text.toString().toInt()
        val numberTwo = binding.editTextDivisionTwo.text.toString().toInt()

        val division = numberOne / numberTwo

        binding.editTextDivisionAnswer.setText(division.toString())

        com.jraska.console.Console.write("\nThe division of $numberOne and $numberTwo is $division")
    }

    private fun getMultiplicationOfTwoNumbers() {
        val numberOne = binding.editTextMultiplicationOne.text.toString().toInt()
        val numberTwo = binding.editTextMultiplicationTwo.text.toString().toInt()

        val multiply = numberOne * numberTwo

        binding.editTextMultiplicationAnswer.setText(multiply.toString())

        com.jraska.console.Console.write("\nThe multiplication of $numberOne and $numberTwo is $multiply")

    }

    private fun getSumOfTwoNumbers() {
        val numberOne = binding.editTextNumberOne.text.toString().toInt()
        val numberTwo = binding.editTextNumberTwo.text.toString().toInt()

        val sum = numberOne + numberTwo

        binding.editTextSumAnswer.setText(sum.toString())

        com.jraska.console.Console.write("\nThe sum of $numberOne and $numberTwo is $sum")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_enable_console_log -> {
                binding.textViewLogging.visibility = View.VISIBLE
            }
            R.id.menu_disable_console_log -> {
                binding.textViewLogging.visibility = View.GONE
            }
            R.id.menu_clear_console_log -> {
                com.jraska.console.Console.clear()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}