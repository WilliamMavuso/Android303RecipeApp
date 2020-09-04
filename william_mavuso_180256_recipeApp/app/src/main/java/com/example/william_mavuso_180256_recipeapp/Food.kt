package com.example.william_mavuso_180256_recipeapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Food : AppCompatActivity() {
    var imageView: ImageView? = null
    var title: TextView? = null
    var description: TextView? = null
    var ingredients: TextView? = null
    var instructions: TextView? = null
    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        //ActionBar
        val actionBar = supportActionBar
        actionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#003333")))
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        }
        imageView = findViewById(R.id.another_imageView)
        title = findViewById(R.id.titleText)
        description = findViewById(R.id.descriptionText)
        ingredients = findViewById(R.id.ingredientsText)
        instructions = findViewById(R.id.instructionsText)


        //PASS DATA: GetIntents from MainActivity
        if (position == 0) {
            val intent = intent
            val bundle = intent.extras
            val pic = bundle!!.getInt("image")
            val aTitle = intent.getStringExtra("title")
            val aDescription = intent.getStringExtra("description")
            val aIngredient = intent.getStringExtra("ingredients")
            val aInstruction = intent.getStringExtra("instructions")
            imageView.setImageResource(pic)
            title.setText(aTitle)
            description.setText(aDescription)
            ingredients.setText(aIngredient)
            instructions.setText(aInstruction)
            actionBar.setTitle(aTitle)
        }
        if (position == 1) {
            val intent = intent
            val bundle = intent.extras
            val pic = bundle!!.getInt("image")
            val aTitle = intent.getStringExtra("title")
            val aDescription = intent.getStringExtra("description")
            val aIngredient = intent.getStringExtra("ingredients")
            val aInstruction = intent.getStringExtra("instructions")
            imageView.setImageResource(pic)
            title.setText(aTitle)
            description.setText(aDescription)
            ingredients.setText(aIngredient)
            instructions.setText(aInstruction)
            actionBar.setTitle(aTitle)

            //If user clicks on imageButton open Youtube Vid

            /*imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ytIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SK98ayjhk1E"));

                    startActivity(ytIntent);
                }
            });

             */
        }
        if (position == 2) {
            val intent = intent
            val bundle = intent.extras
            val pic = bundle!!.getInt("image")
            val aTitle = intent.getStringExtra("title")
            val aDescription = intent.getStringExtra("description")
            val aIngredient = intent.getStringExtra("ingredients")
            val aInstruction = intent.getStringExtra("instructions")
            imageView.setImageResource(pic)
            title.setText(aTitle)
            description.setText(aDescription)
            ingredients.setText(aIngredient)
            instructions.setText(aInstruction)
            actionBar.setTitle(aTitle)
        }
        if (position == 3) {
            val intent = intent
            val bundle = intent.extras
            val pic = bundle!!.getInt("image")
            val aTitle = intent.getStringExtra("title")
            val aDescription = intent.getStringExtra("description")
            val aIngredient = intent.getStringExtra("ingredients")
            val aInstruction = intent.getStringExtra("instructions")
            imageView.setImageResource(pic)
            title.setText(aTitle)
            description.setText(aDescription)
            ingredients.setText(aIngredient)
            instructions.setText(aInstruction)
            actionBar.setTitle(aTitle)
        }
    }
}