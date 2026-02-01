# Task 2 – Sensor Data Reader Application

## Overview

An Android application that:

- Detects all available sensors on the device
- Allows the user to select a sensor from a dropdown (Spinner)
- Displays real-time sensor values
- Properly manages sensor registration/unregistration to save battery

## Features

- Dynamic sensor detection (only shows sensors actually present)
- Real-time updates using `SensorEventListener`
- Efficient lifecycle handling (`onResume` / `onPause`)
- Clean, responsive UI with ConstraintLayout
- Meaningful error messages for unavailable sensors

## Supported Sensors (if available on device)

- Accelerometer (X, Y, Z values in m/s²)
- Gyroscope (rad/s)
- Pressure / Barometer (hPa)
- Ambient Temperature (°C)
- Light (lux)
- Proximity (cm)
- Magnetometer (μT)
- And any other sensors the device supports


## Technologies

- Kotlin
- Android Sensor API (`SensorManager`, `SensorEventListener`)
- ConstraintLayout
- Spinner + ArrayAdapter
- Function types / lambdas for clean callbacks

## How to Run

1. Open `SensorApp/` folder in Android Studio
2. Sync Gradle
3. Run on emulator or real device (min SDK 24)

**Note:** Some sensors (Pressure, Ambient Temperature) are rare on consumer devices and may not appear on your phone. This is expected behavior — the app only shows what's actually available.

## Implementation Highlights

- Sensors are checked using `getDefaultSensor()` → only real ones added
- Listener registered in `onResume()`, unregistered in `onPause()`
- Clean separation: UI in Activity, sensor logic in `SensorHandler` class
- Uses `SENSOR_DELAY_UI` for balanced performance & battery usage
- Human-readable formatting for accelerometer (X/Y/Z) and other sensors
