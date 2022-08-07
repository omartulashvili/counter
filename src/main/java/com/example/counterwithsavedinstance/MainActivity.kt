package com.example.counterwithsavedinstance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var result: TextView
    lateinit var buttonCounter: Button

    private var counter = 0
        set(value) {
            field = value
            result.text = value.toString()
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.counterTextView)
        buttonCounter = findViewById(R.id.incrementButton)

        buttonCounter.setOnClickListener {
            if (counter >= 0) {
                counter++
                result.text = counter.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT_KEY", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter = savedInstanceState.getInt("COUNT_KEY")
    }
}