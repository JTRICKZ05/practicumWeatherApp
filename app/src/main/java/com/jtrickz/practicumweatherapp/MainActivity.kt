package com.jtrickz.practicumweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //declare variables
    //the keyword lateinit allows us to initialize a variable at a later stage
    private lateinit var nextButton: Button
    private lateinit var closeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //making use of the find view by ID method
        //initializing the variable by getting reference to the button
        //get reference by using the ID name


        nextButton = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            closeButton = findViewById(R.id.closeButton)
            closeButton.setOnClickListener {


                //create variable
                val Intent = Intent(this, MainActivity2::class.java)
                startActivity(Intent)
                finish()
            }
        }
    }
}
