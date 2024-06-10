package com.jtrickz.practicumweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    //declare
    private lateinit var clearButton: Button
    private lateinit var viewTemperatureButton: Button
    private lateinit var mondayInput: EditText
    private lateinit var tuesdayInput: EditText
    private lateinit var wednesdayInput: EditText
    private lateinit var thursdayInput: EditText
    private lateinit var fridayInput: EditText
    private lateinit var saturdayInput: EditText
    private lateinit var sundayInput: EditText

    private lateinit var inputs: Array<EditText>
    private var temperatureInputs: DoubleArray = DoubleArray(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

                clearButton = findViewById(R.id.clearButton)
                viewTemperatureButton = findViewById(R.id.viewTemperatureButton)
                mondayInput = findViewById(R.id.mondayInput)
                tuesdayInput = findViewById(R.id.tuesdayInput)
                wednesdayInput = findViewById(R.id.wednesdayInput)
                thursdayInput = findViewById(R.id.thursdayInput)
                fridayInput = findViewById(R.id.fridayInput)
                saturdayInput = findViewById(R.id.saturdayInput)
                sundayInput = findViewById(R.id.sundayInput)

                inputs = arrayOf(
                    mondayInput,
                    tuesdayInput,
                    wednesdayInput,
                    thursdayInput,
                    fridayInput,
                    saturdayInput,
                    sundayInput
                )

                clearButton.setOnClickListener {
                    clearInputs()
                }

                viewTemperatureButton.setOnClickListener {
                    if (validateInputs()) {
                        temperatureInputs = inputs.map { it.text.toString().toDouble() }.toDoubleArray()

                        val intent = Intent(this, MainActivity3::class.java)
                        intent.putExtra("temperatureInputs", temperatureInputs)
                        startActivity(intent)

                    } else {

                        Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            private fun clearInputs() {

                for (input in inputs) {
                    input.text.clear()

                }
            }

            private fun validateInputs(): Boolean {

                for (input in inputs) {
                    if (input.text.isEmpty() || input.text.toString().toDoubleOrNull() == null) {
                        return false
                    }
                }
                return true
            }
        }
