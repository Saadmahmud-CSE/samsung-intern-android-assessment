# Samsung R&D Institute Bangladesh – Android Developer Internship Assessment

**Submitted by:** Mohammad Saad Uddin Chowdhury
**Date:** February 1, 2026

This repository contains the complete solution for the Android Developer Internship assessment at Samsung R&D Institute Bangladesh (SRBD).

## Tasks Completed

1. **Task 1 – Basic Calculator Application**  
   A simple calculator supporting addition, subtraction, multiplication, and division with proper input validation and error handling.

2. **Task 2 – Sensor Data Reader Application**  
   An Android app that detects all available sensors on the device, allows dynamic selection via Spinner, and displays real-time sensor values with efficient lifecycle management.

3. **Task 3 – Developer Evangelist Blog**  
   A step-by-step technical blog post (in Markdown) explaining the design decisions, architecture, and implementation details of the Sensor Data Reader application.

## Project Structure
```bash
Samsung-Intern-Assessment/
├── CalculatorApp/                    # Task 1 – Calculator Application
│   ├── app/
│   │   ├── src/
│   │   └── res/
│   ├── build.gradle
│   └── README.md
│
├── SensorApp/                        # Task 2 – Sensor Data Reader
│   ├── app/
│   │   ├── src/
│   │   └── res/
│   ├── build.gradle
│   └── README.md
│
├── Task-3-Blog/                      # Task 3 – Technical Blog
│   └── Sensor-Data-Reader-Blog.md
│
└── README.md                         # This file
```

## Technologies Used (Both Apps)

- Language: **Kotlin** (100%)
- UI: **ConstraintLayout**
- Architecture: Clean separation of concerns (UI + Sensor handling logic)
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- No external dependencies (pure AndroidX)

## How to Build and Run

1. Clone the repository:
```bash
git clone https://github.com/Saadmahmud-CSE/samsung-intern-android-assessment.git
