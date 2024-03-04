package com.example.codepathwordle

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.floor

class PopUpActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up)
        val word=intent.getStringExtra("word");
        val win=intent.getStringExtra("win")
        val wordView=findViewById<TextView>(R.id.wordView);
        val winView=findViewById<TextView>(R.id.winView);
        val goHomeIntent= Intent(this, StartUp::class.java )
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            startActivity(goHomeIntent)
            finish()



        }


        wordView.setText(word)
        winView.setText(win)

        //code for making popup. Will explore later
        /*

        val displayMetrics = DisplayMetrics()


        windowManager.defaultDisplay.getMetrics(displayMetrics)


        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        // Gets linearlayout
        val layout: ConstraintLayout = findViewById(R.id.popup)
// Gets the layout params that will allow you to resize the layout
        val params = layout.layoutParams
        params.width = (width*.8).toInt()
        params.height = (height*.8).toInt()
        layout.layoutParams = params
*/


    }


}
