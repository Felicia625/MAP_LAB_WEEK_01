package com.example.lab_week_01

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast
import android.widget.Button
import android.view.Gravity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)
                ?.text.toString().trim()

            if(nameInput.isEmpty() || nimInput.isEmpty()){
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                return@setOnClickListener
            }
            if(nimInput.length != 11){
                Toast.makeText(this, getString(R.string.nim_error), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                return@setOnClickListener
            }

            nameDisplay.text = getString(R.string.name_greet)+" "+nameInput+"\n"+getString(R.string.nim_greet)+" "+nimInput
        }

    }

}