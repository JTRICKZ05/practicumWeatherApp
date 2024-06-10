package com.jtrickz.practicumweatherapp

import android.annotation.SuppressLint
import android.icu.util.Calendar.WeekData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    private lateinit var temperatureInputs: DoubleArray
    private lateinit var return_Button: Button
    private lateinit var detailsTextView: TextView
    private lateinit var temperature_Text_View: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

            return_Button = findViewById(R.id.returnButton)
            temperature_Text_View = findViewById(R.id.temperature_Text_View)
            detailsTextView = findViewById(R.id.detailsTextView)
            temperatureInputs = intent.getDoubleArrayExtra("temperatureInputs") ?: DoubleArray(7)

            displayDetails()

            return_Button.setOnClickListener {
                finish()
            }

            val intent = intent
            val bundle = intent.extras
            if (bundle != null) {
                val temperatureInputsArray = bundle.getDoubleArray("average temperature")
                if (temperatureInputsArray != null) {
                    temperatureInputs = temperatureInputsArray
                }
            }
        }

        private fun displayDetails() {
            val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

            temperature_Text_View.text = buildString {
                for (i in days.indices) {
                    append("${days[i]}: ${temperatureInputs[i]}°C\n") //Display degreees Celsius
                }
            }

            val averageTemperature= temperatureInputs.average()
            detailsTextView.text = "Average Temperature: 22°C".format(averageTemperature)
        }
    }

