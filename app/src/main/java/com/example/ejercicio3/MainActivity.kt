package com.example.ejercicio3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1EditText: EditText = findViewById(R.id.num1EditText)
        val num2EditText: EditText = findViewById(R.id.num2EditText)
        val operadorSpinner: Spinner = findViewById(R.id.operadorSpinner)
        val calcularButton: Button = findViewById(R.id.calcularButton)
        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)

        val operadores = arrayOf("+", "-", "*", "/")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operadores)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operadorSpinner.adapter = adapter

        calcularButton.setOnClickListener {
            val num1 = num1EditText.text.toString().toDouble()
            val num2 = num2EditText.text.toString().toDouble()
            val operador = operadorSpinner.selectedItem.toString()

            val resultado = calcular(num1, num2, operador)

            resultadoTextView.text = "Resultado: $resultado"
        }
    }

    private fun calcular(num1: Double, num2: Double, operador: String): Double {
        return when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("Operador no válido")
        }
    }
}