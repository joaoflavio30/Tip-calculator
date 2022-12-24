package com.example.tipcalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.amount.setText(R.string.tip_amount)

        binding.button2.setOnClickListener {
            calculateTip()

        }
    }


    private fun calculateTip() {
        var inputText = binding.editText.text.toString().toDoubleOrNull()
        if (inputText == null) {
            displayTip(0.0)
            return
        }
        when (binding.RadioGroup.checkedRadioButtonId) {
            R.id.radioButton2 -> inputText *= 0.2
            R.id.radioButton3 -> inputText *= 0.18
            R.id.radioButton4 -> inputText *= 0.15
        }

        val result: Double = if (binding.textView2.isChecked) {
            kotlin.math.ceil(inputText)
        } else {
            inputText
        }
        displayTip(result)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.amount.text = getString(R.string.amount, formattedTip)
    }


}


