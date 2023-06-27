package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        /**
         * button clicked will run rollDice function
         */
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!",  Toast.LENGTH_SHORT).show()
//            val resultTextView:TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            rollDice()
        }
        rollDice()
    }

    /**
     * this function rolls the dice and show the result in text view
     */
    private fun rollDice() {
        //creates dice object and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //updates the view into dice result
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
//        when(diceRoll){
//            1->diceImage.setImageResource(R.drawable.dice_1)
//            2->diceImage.setImageResource(R.drawable.dice_2)
//            3->diceImage.setImageResource(R.drawable.dice_3)
//            4->diceImage.setImageResource(R.drawable.dice_4)
//            5->diceImage.setImageResource(R.drawable.dice_5)
//            6->diceImage.setImageResource(R.drawable.dice_6)
//        }

        val drawableResource = when (diceRoll){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            6-> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        diceImage.contentDescription = diceRoll.toString()
        diceImage.setImageResource(drawableResource)

    }
}

/**
 * this class randomize the dice side
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}