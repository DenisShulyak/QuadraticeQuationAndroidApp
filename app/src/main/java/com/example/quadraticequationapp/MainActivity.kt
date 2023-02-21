package com.example.quadraticequationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.quadraticequationapp.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numberA: EditText
    private lateinit var numberB: EditText
    private lateinit var numberC: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numberA = binding.editTextNumberA
        numberB = binding.editTextNumberB
        numberC = binding.editTextNumberC
        button = binding.buttonResult
        textView = binding.textViewResult
    }

    fun onClick(view: View){

        val numA = numberA.text.toString().toDoubleOrNull()
        val numB = numberB.text.toString().toDoubleOrNull()
        val numC = numberC.text.toString().toDoubleOrNull()

        if (numA != null && numB != null && numC != null) {
            if (numA.equals(0.0)){
                textView.text = "Коэффициент 'a' не может быть равен 0!"
                return
            }
            val discriminant = numB * numB - 4 * numA * numC
            if (discriminant < 0) {
                textView.text = "Дискриминант < 0, корней нет!"
                return
            }
            val x1 = (-numB + Math.sqrt(discriminant)) / (2 * numA)
            val x2 = (-numB - Math.sqrt(discriminant)) / (2 * numA)
            if(x1 == x2){
                textView.text = "x = " + x1
            }
            else{
                textView.text = "x1 = " + x1 + "\n" + "x2 = " + x2
            }

        } else {
            textView.text = "Заполните поля!"
        }
    }
}