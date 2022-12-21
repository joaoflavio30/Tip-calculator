package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import kotlin.math.roundToInt

private var serviceRate = "Nothing"
private val amazing = "amazing"
private val good = "good"
private const val ok = "ok"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input = findViewById<EditText>(R.id.editTextTextPersonName).text


        val calculateBtn = findViewById<Button>(R.id.button2)
        calculateBtn.setOnClickListener{
            stateBtnRadio()
            if(serviceRate!="Nothing" && input.isNotEmpty()) {
                calc(input.toString())
            }
        }


    }


    private fun stateBtnRadio(){
        val btnRadio2 = findViewById<RadioButton>(R.id.radioButton2)
        val btnRadio3 = findViewById<RadioButton>(R.id.radioButton3)
        val btnRadio4 = findViewById<RadioButton>(R.id.radioButton4)

        if(btnRadio2.isChecked){
            serviceRate = amazing
        }else if(btnRadio3.isChecked){
            serviceRate = good
        }else if(btnRadio4.isChecked){
            serviceRate = ok
        }

    }

    private fun calc(number : String){
        val resultCalc = findViewById<TextView>(R.id.textViewPrice)
        val roundUp = findViewById<Switch>(R.id.textView2)
        when(serviceRate){
            amazing -> resultCalc.text = (number.toDouble() * 1.2).toString()
            good -> resultCalc.text = (number.toDouble() * 1.18).toString()
            ok -> resultCalc.text = (number.toDouble() * 1.15).toString()
        }
        if (roundUp.isChecked){
          resultCalc.text = resultCalc.text.toString().toDouble().roundToInt().toString()

        }
    }



}


