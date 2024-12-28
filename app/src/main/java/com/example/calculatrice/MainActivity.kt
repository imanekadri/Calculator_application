package com.example.calculatrice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentInput = ""
    private var operator: Char? = null
    private var num1: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = listOf(
            findViewById<Button>(R.id.btn_0),
            findViewById<Button>(R.id.btn_1),
            findViewById<Button>(R.id.btn_2),
            findViewById<Button>(R.id.btn_3),
            findViewById<Button>(R.id.btn_4),
            findViewById<Button>(R.id.btn_5),
            findViewById<Button>(R.id.btn_6),
            findViewById<Button>(R.id.btn_7),
            findViewById<Button>(R.id.btn_8),
            findViewById<Button>(R.id.btn_9),
            findViewById<Button>(R.id.btn_dot) // Button for the decimal point
        )

        val addButton = findViewById<Button>(R.id.btn_add)
        val subtractButton = findViewById<Button>(R.id.btn_subtract)
        val multiplyButton = findViewById<Button>(R.id.btn_multiply)
        val divideButton = findViewById<Button>(R.id.btn_divide)
        val equalButton = findViewById<Button>(R.id.btn_equals)
        val resultView = findViewById<TextView>(R.id.display)
        val openButton = findViewById<Button>(R.id.btn_open)
       val closeButton =  findViewById<Button>(R.id.btn_close)
        val clearButton = findViewById<Button>(R.id.btn_clear)

        buttons.forEach { button ->
            button.setOnClickListener {
                currentInput += button.text
                resultView.text = currentInput
            }
        }

        addButton.setOnClickListener {
            if (num1 == null && currentInput.isNotEmpty()) {
                num1 = currentInput.toDouble()
                operator = '+'
                currentInput += " $operator "
                resultView.text = currentInput
            }
        }

        subtractButton.setOnClickListener {
            if (num1 == null && currentInput.isNotEmpty()) {
                num1 = currentInput.toDouble()
                operator = '-'
                currentInput += " $operator "
                resultView.text = currentInput
            }
        }

        multiplyButton.setOnClickListener {
            if (num1 == null && currentInput.isNotEmpty()) {
                num1 = currentInput.toDouble()
                operator = '*'
                currentInput += " $operator "
                resultView.text = currentInput
            }
        }

        divideButton.setOnClickListener {
            if (num1 == null && currentInput.isNotEmpty()) {
                num1 = currentInput.toDouble()
                operator = '/'
                currentInput += " $operator "
                resultView.text = currentInput
            }
        }

//        openButton.setOnClickListener {
//            if (num1 == null && currentInput.isNotEmpty()) {
//                num1 = currentInput.toDouble()
//                operator = '('
//                currentInput += " $operator "
//                resultView.text = currentInput
//            }
//        }

//        closeButton.setOnClickListener {
//            if (num1 == null && currentInput.isNotEmpty()) {
//                num1 = currentInput.toDouble()
//                operator = ')'
//                currentInput += " $operator "
//                resultView.text = currentInput
//            }
//        }

        clearButton.setOnClickListener{
            currentInput = ""
                resultView.text = ""
      }

        equalButton.setOnClickListener {
            if (num1 != null && currentInput.isNotEmpty()) {
                val parts = currentInput.split(" ")
                if (parts.size == 3) {
                    val num2 = parts[2].toDouble()
                    val result = when (operator) {
                        '+' -> num1!! + num2
                        '-' -> num1!! - num2
                        '*' -> num1!! * num2
                        '/' -> if (num2 != 0.0) num1!! / num2 else Double.NaN // Handling division by zero
                        else -> 0.0
                    }
                    resultView.text = result.toString()
                    resetCalculator()
                }
            }
        }
    }

    private fun resetCalculator() {
        currentInput = ""
        num1 = null
        operator = null
    }
}
