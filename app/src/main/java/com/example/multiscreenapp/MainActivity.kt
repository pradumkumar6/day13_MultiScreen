package com.example.multiscreenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // creating key
    companion object{
        const val  KEY = "com.example.multiscreenapp.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonOrder = findViewById<Button>(R.id.btnOrder)
        val editT1 = findViewById<EditText>(R.id.eT1)
        val editT2 = findViewById<EditText>(R.id.eT2)
        val editT3 = findViewById<EditText>(R.id.eT3)
        val editT4 = findViewById<EditText>(R.id.eT4)
        buttonOrder.setOnClickListener {
            val orderPlaced = editT1.text.toString() + " " + editT2.text.toString() + " " + editT3.text.toString() + " " + editT4.text.toString()
            intent= Intent(this,Order::class.java)
            intent.putExtra(KEY,orderPlaced) // key -> value pairs
            startActivity(intent)

        }


    }
}