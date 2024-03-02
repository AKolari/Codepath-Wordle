package com.example.codepathwordle

import FourLetterWordList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.color
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {

    var wordToGuess= FourLetterWordList.getRandomFourLetterWord()
    var guessLength=0;
    var currentGuess=1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textField=findViewById<EditText>(R.id.editTextText)
        //textField.setText(wordToGuess)
        val submitButton=findViewById<Button>(R.id.button)
        submitButton.isEnabled=false;
        val answerText=findViewById<TextView>(R.id.Answer)
        answerText.text=wordToGuess




        //Add an onChange listener to the input field

        textField.addTextChangedListener( object:TextWatcher{


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                guessLength=textField.length()
                if(guessLength==wordToGuess.length){
                    submitButton.isEnabled=true
                }
                else{
                    submitButton.isEnabled=false
                }
            }

            override fun afterTextChanged(s: Editable) {
            }

        }  )


        //Set onClickListener for Button

        submitButton.setOnClickListener{
            val guessTextIds = arrayOf(R.id.guess1Text, R.id.guess2Text, R.id.guess3Text)

            if(currentGuess<4) {

                val currentGuessText = findViewById<TextView>(guessTextIds[currentGuess - 1]);
                currentGuessText.text = checkGuess(textField.text.toString().uppercase())
                currentGuess++



                if(currentGuess==4 || currentGuessText.text.toString().equals(wordToGuess)){
                    guessLength=4;
                    textField.isEnabled=false;
                    answerText.isVisible=true;
                    submitButton.text="Restart"
                }
            }
            else{

                wordToGuess= FourLetterWordList.getRandomFourLetterWord()
                guessLength=0;
                currentGuess=1;
                textField.isEnabled=true;
                submitButton.text="Submit"
                answerText.text=wordToGuess
                textField.setText("Guess?")
                answerText.isInvisible=true

                for (i in guessTextIds){
                    val tV = findViewById<TextView>(i)
                    tV.text=""
                }

            }





        }





    }



    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : SpannableStringBuilder {
        var result = SpannableStringBuilder()
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result.color(Color.GREEN) { append(guess[i]) }
            }
            else if (guess[i] in wordToGuess) {
                result.color(Color.BLUE) { append(guess[i]) }
            }
            else {
                result.color(Color.RED) { append(guess[i]) }
            }
        }
        return result
    }


}