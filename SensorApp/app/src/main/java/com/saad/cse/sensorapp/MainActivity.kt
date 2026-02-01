package com.saad.cse.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var spinnerSensors: Spinner
    private lateinit var tvValue: TextView
    private lateinit var tvStatus: TextView

    private var sensorList: List<Sensor> = emptyList()
    private var activeSensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerSensors = findViewById(R.id.sensorSpinner)
        tvValue = findViewById(R.id.sensorValueText)
        tvStatus = findViewById(R.id.statusText)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        loadAllSensors()
    }

    private fun loadAllSensors() {
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL)

        if (sensorList.isEmpty()) {
            tvStatus.text = "No sensors found on this device"
            spinnerSensors.visibility = View.GONE
            return
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sensorList.map { it.name }
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSensors.adapter = adapter

        spinnerSensors.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    changeSensor(sensorList[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        changeSensor(sensorList[0])
    }

    private fun changeSensor(sensor: Sensor) {
        sensorManager.unregisterListener(this)
        activeSensor = sensor
        tvStatus.text = ""
        tvValue.text = "Reading ${sensor.name}..."
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        val valuesText = event.values
            .mapIndexed { index, value ->
                "Value ${index + 1}: %.2f".format(value)
            }
            .joinToString("\n")

        tvValue.text = buildString {
            appendLine(event.sensor.name)
            appendLine("---------------------")
            append(valuesText)
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
