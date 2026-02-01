package com.saad.cse.calculatorapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1Edit = findViewById<EditText>(R.id.num1)
        val num2Edit = findViewById<EditText>(R.id.num2)
        val operatorSpinner = findViewById<Spinner>(R.id.operatorSpinner)
        val resultText = findViewById<TextView>(R.id.resultText)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)

        val operators = arrayOf("+", "-", "*", "/")
        operatorSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            operators
        )

        calculateBtn.setOnClickListener {

            val num1Str = num1Edit.text.toString().trim()
            val num2Str = num2Edit.text.toString().trim()

            if (num1Str.isEmpty()) {
                num1Edit.error = "Please enter Number 1"
                num1Edit.requestFocus()
                return@setOnClickListener
            }

            if (num2Str.isEmpty()) {
                num2Edit.error = "Please enter Number 2"
                num2Edit.requestFocus()
                return@setOnClickListener
            }

            resultText.visibility = android.view.View.INVISIBLE

            try {
                val n1 = num1Str.toDouble()
                val n2 = num2Str.toDouble()
                val op = operatorSpinner.selectedItem.toString()

                val result = Calculator.calculate(n1, n2, op)

                resultText.setTextColor(getColor(R.color.result_color))
                resultText.text = "Result: $result"
                resultText.visibility = android.view.View.VISIBLE

                num1Edit.text.clear()
                num2Edit.text.clear()

            } catch (e: ArithmeticException) {
                resultText.setTextColor(getColor(R.color.error_color))
                resultText.text = e.message
                resultText.visibility = android.view.View.VISIBLE

            } catch (e: NumberFormatException) {
                resultText.setTextColor(getColor(R.color.error_color))
                resultText.text = "Invalid number format"
                resultText.visibility = android.view.View.VISIBLE

            } catch (e: Exception) {
                resultText.setTextColor(getColor(R.color.error_color))
                resultText.text = "Something went wrong"
                resultText.visibility = android.view.View.VISIBLE
            }
        }
    }
}
