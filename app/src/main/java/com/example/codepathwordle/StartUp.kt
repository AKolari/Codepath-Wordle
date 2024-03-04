package com.example.codepathwordle

import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class StartUp : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val startButton = findViewById<Button>(R.id.buttonStart)
        val rulesButton = findViewById<Button>(R.id.buttonRules)
        val allTextViews= arrayOf(findViewById<TextView>(R.id.h1), findViewById<TextView>(R.id.h2),
            findViewById<TextView>(R.id.textView), findViewById<TextView>(R.id.textView2), findViewById<TextView>(R.id.textView3))
        var showRules=false





        startButton.setOnClickListener{
            val startIntent= Intent(this, MainActivity::class.java )
            startActivity(startIntent)
            finish()


        }

        rulesButton.setOnClickListener{
            if(showRules){
                showRules=false
                allTextViews[1].isVisible=true;
                allTextViews[0].text= "Wordle, But Worse "
                allTextViews[2].isInvisible=true
                allTextViews[3].isInvisible=true
                allTextViews[4].isInvisible=true
                startButton.isVisible=true
                rulesButton.setText("Rules")

            }
            else{
                showRules=true
                allTextViews[1].isInvisible=true;
                allTextViews[0].text= "Guess a Four Letter Word"
                allTextViews[2].isVisible=true
                allTextViews[3].isVisible=true
                allTextViews[4].isVisible=true
                startButton.isInvisible=true
                rulesButton.setText("Go Back")
            }


        }








    }





}
