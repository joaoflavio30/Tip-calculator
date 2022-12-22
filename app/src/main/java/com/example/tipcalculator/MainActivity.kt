package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip(){
        var inputText = binding.editTextTextPersonName.text.toString().toDouble()
        var result = binding.textViewPrice
        when(binding.RadioGroup.checkedRadioButtonId){
            R.id.radioButton2 -> inputText *= 0.2
            R.id.radioButton3 -> inputText *= 0.18
            R.id.radioButton4 -> inputText *= 0.15
        }
        val roundUp = binding.textView2.isChecked
        if(roundUp){
          result.text=kotlin.math.ceil(inputText).toString()
        }else{ result.text=inputText.toString()
        }

    }

}


