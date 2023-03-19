package com.example.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * activity ini untuk user menekan tombol roll tersebut
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
//      di bawah ini untuk menampilkan dadu saat aplikasi pertama kali di buka
        rollDice()
    }

    //Roll the dice and update the screen with the result.
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()


        // Update the screen with the dice roll
//        val resultTextView: TextView = findViewById(R.id.textView)
        val diceImage: ImageView = findViewById(R.id.imageView)

//        val resultTextView2: TextView = findViewById(R.id.textView2)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID

        diceImage.setImageResource(drawableResource)
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID

        diceImage2.setImageResource(drawableResource2)
        // Update the content description

        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        // pengkondisian terhadap dadu yang sama atau beda terhadap pesan yang muncul ke layar
        if (diceRoll == diceRoll2) {
            val toast = Toast.makeText(
                this,
                "Selamat anda dapat dadu double yang sama!",
                Toast.LENGTH_SHORT
            )
            toast.show()
        } else {
            val toast2 = Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT)
            toast2.show()
        }
    }

}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}