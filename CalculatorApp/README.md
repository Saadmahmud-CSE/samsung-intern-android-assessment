# Task 1 – Basic Calculator Application

## Overview

A simple Android calculator application that performs basic arithmetic operations:

- Addition (+)
- Subtraction (−)
- Multiplication (×)
- Division (÷)

## Features

- Two decimal number inputs (EditText)
- Operator selection via Spinner
- "Calculate" button to compute result
- Clear error handling:
  - Empty input fields
  - Division by zero
- Clean, modern UI using ConstraintLayout
- Result displayed prominently

## Screenshots

(Add 2–3 screenshots here if possible – input screen, result screen, error message)

## Technologies

- Kotlin
- ConstraintLayout
- Spinner + ArrayAdapter
- EditText with numberDecimal inputType

## How to Run

1. Open `CalculatorApp/` folder in Android Studio
2. Sync Gradle
3. Run on emulator or device (min SDK 24)

## Implementation Highlights

- Input validation before calculation
- Throws and catches `ArithmeticException` for division by zero
- Clears input fields after successful calculation