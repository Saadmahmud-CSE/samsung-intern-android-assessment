package com.saad.cse.calculatorapp

object Calculator {
    fun calculate(num1: Double, num2: Double, operator: String): Double {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 == 0.0) throw ArithmeticException("Math Error")
                num1 / num2
            }
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }
}