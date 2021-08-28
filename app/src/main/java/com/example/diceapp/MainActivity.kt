package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // create a Dice class with ability to give random figures between 1 to 6 when rolled
    class Dice(private val sides: Int) {
        fun roll(): Int {
            return (1..sides).random()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // give dice ability to roll at click of button and display confirmation text
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    // create two dice with 6 sides each and give ability to return result when rolled
    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        //set images for each result displayed
        val image1: ImageView = findViewById(R.id.diceImage1)
        val image2: ImageView = findViewById(R.id.diceImage2)
        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image1.setImageResource(R.drawable.empty_dice)
        image1.setImageResource(drawableResource1)
        image1.contentDescription = diceRoll1.toString()
        image2.setImageResource(R.drawable.empty_dice)
        image2.setImageResource(drawableResource2)
        image2.contentDescription = diceRoll2.toString()
    }
}