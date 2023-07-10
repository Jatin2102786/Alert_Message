package com.jatin.alert_message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var tvValue:TextView
    lateinit var alertButton:Button
    var number=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvValue=findViewById(R.id.tv_value)
        alertButton=findViewById(R.id.btn_alert)
        tvValue.setText(number.toString())
        alertButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Value changer")
                .setMessage("press any button")
                .setCancelable(false)
                .setPositiveButton("Increment"){_,_->
                    number=number+2
                    tvValue.setText(number.toString())

                    Toast.makeText(this, "Incremented", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decrement"){_,_->
                    Toast.makeText(this, "Decrement", Toast.LENGTH_SHORT).show()
                    number=number-2
                    tvValue.setText(number.toString())
                }
                .setNeutralButton("Neutral"){_,_->
                    number=0
                    tvValue.setText(number.toString())
                    Toast.makeText(this, "Default Value", Toast.LENGTH_SHORT).show()

                }
                .show()
        }
    }
}