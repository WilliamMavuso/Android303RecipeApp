package com.example.william_mavuso_180256_recipeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.william_mavuso_180256_recipeapp.MainActivity

open class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var mTitle = arrayOf(
        "Pan Fried Dumplings",
        "Beef Ramen Noodles",
        "Italian Chicken Supper",
        "Club Sandwich"
    )
    var mDescription = arrayOf(
        " Level: Easy \n Duration: 30 minutes ",
        " Level: Easy \n Duration: 25 minutes",
        " Level: Moderate\n Duration: 40 minutes",
        " Level: Easy \n Duration: 15 minutes"
    )
    var mIngredients = arrayOf( //Meal 1
        """
              1/2 cup finely chopped bok choy leaves
              1/2 cup finely chopped napa cabbage
              1/4 cup finely chopped green onion
              1/4 cup chopped water chestnuts
              1 pound ground pork
              1 teaspoon light soy sauce
              1 teaspoon dark soy sauce
              2 teaspoons Chinese rice wine or dry sherry
              1 teaspoon sesame oil
              Dash of white pepper
              """.trimIndent(),  //Meal 2
        """
              2 tablespoons canola oil
              1 pound top sirloin steak sliced thinly against the grain
              8 ounces ramen noodles cooked and drained
              1 red bell pepper thinly sliced
              1 large onion thinly sliced
              3 carrots shredded
              8 ounces baby bok choy roughly chopped, white and green parts separated
              4 ounces shiitake mushrooms sliced
              Sesame seeds for garnish, optional
              sliced green onion for garnish, optional
              """.trimIndent(),  //Meal 3
        """
              1/4 cup balsamic vinegar
              1 teaspoon dried parsley flakes
              1 teaspoon dried basil
              1 teaspoon kosher salt
              1/2 teaspoon freshly cracked black pepper
              5 cloves garlic, minced
              1 cup plus 3 tablespoons olive oil
              8 bone-in, skin-on chicken thighs
              1 pound green beans
              2 cups mixed cherry tomatoes
              1 loaf crusty ciabatta bread
              2 tablespoons minced fresh parsley

              """.trimIndent(),  //Meal 4
        """
              3 slices wheat bread (or bread of choice)
              2 Tablespoons mayo (I recommend Duke's, Hellmann's or Trader Joe's)
              lettuce
              tomato slices
              salt and pepper to taste (on the tomatoes)
              2 ounces sliced deli ham
              2 ounces sliced turkey
              2 slices bacon cooked
              1 slice Colby jack cheese (or cheese of choice - cheddar and Swiss work great too)
              """.trimIndent()
    )
    var mInsructions = arrayOf( //Meal 1
        """
              1. Gather the ingredients.

              2. Combine the filling ingredients in a large bowl, using your fingers to mix everything together. If preparing the filling ahead of time, store in a sealed container in the refrigerator until ready to use.

              3. Gently lift the edges of the moistened wrapper over the filling and bring together at the top center. Crimp the edges of the wrapper several times along the edge and pinch together to seal. Repeat with the remaining wonton wrappers and filling.

              4. Heat a wok or nonstick skillet over medium-high heat and add the oil. Add 10 to 12 potstickers at a time and cook for 2 to 3 minutes until the bottoms are browned.

              5. Add 1/3 cup water, cover, and steam the dumplings until the liquid is absorbed, about 5 minutes.

              6. Remove and cook the remainder of the dumplings, adding water as needed, keeping the amount to about 1/3 cup.

              7. Serve alone or with a homemade dipping sauce.

              8. Enjoy!
              """.trimIndent(),  //Meal 2
        """
              1. Whisk together all ingredients for the sauce, set aside.

              2. In a large skillet or wok, heat 1 tablespoon of oil over medium high heat. When hot, add the beef and cook for 2-3 minutes per side, until cooked through. This may need to be done in two batches to avoid crowding the pan. Remove beef from pan and drain off any excess liquid, wipe or rinse pan if needed.

              3. Return pan to heat and allow any excess moisture to evaporate. Add remaining tablespoon of oil to pan.

              4. When hot, add onion and cook for 2-3 minutes, stirring as needed, until onion is starting to soften.

              5. Add bell pepper, mushrooms and white parts of bok choy and cook for another 3-4 minutes.

              6. Add carrots and green parts of bok choy, cook for another 2 minutes

              7. When vegetables are crisp tender, add the beef and noodles to the pan.  Pour in the sauce, stirring to mix and coat everything in the sauce.

              8. Cook for 1-2 minutes, until sauce has thickened.

              9. Remove from heat. Garnish with sesame seeds and green onion if desired and serve.
              """.trimIndent(),  //Meal 3
        """
              1. Preheat the oven to 425 degrees F.

              2. To a bowl or pitcher, add the vinegar, parsley, basil, salt, pepper, garlic and 1 cup of the olive oil. Whisk until well combined.

              3. Put the chicken in a large zipper bag and pour in half the dressing. Seal the bag and squish to coat the chicken.

              4. Trim the ends of the green beans and put in a large bowl with the tomatoes. Pour over the remaining dressing and toss.

              5. Using tongs, arrange the chicken skin-side up on a sheet pan. Use a slotted spoon to transfer the beans and tomatoes to the sheet pan, leaving the excess marinade behind. Roast for 20 minutes.

              6. Meanwhile, rip the bread into large chunks. Add to a bowl, drizzle with the remaining 3 tablespoons olive oil and toss.

              7. After the chicken and vegetables have roasted for 20 minutes, shake the pan to prevent sticking, then add the bread chunks to the pan. Continue to roast until the chicken is cooked through and the skin is golden and crisp, about another 10 minutes. Sprinkle the sheet pan with parsley and serve.
              """.trimIndent(),  //Meal 4
        """
              1. Toast your bread, if you wish, and allow it to cool for a few minutes. This helps to avoid wilted lettuce.

              2. Spread the 3 pieces of cooled toast with mayo.

              3. On one slice, add your lettuce and tomato. Go ahead and add a little salt and pepper to those tomatoes.

              4. Put a 2nd piece of bread, mayo side down, on the sandwich. Then add a little more mayo to the top of that piece.

              5. Next, stack your meat and cheese, and top with the last slice of bread, mayo side down.

              6. Use a well-sharpened knife to cut the sandwich into triangles, using toothpicks to hold everything together.

              7. To up the visual game of your club sandwich, turn everything on its side to show all the pretty layers.

              8. Serve immediately and enjoy!
              """.trimIndent()
    )
    var images = intArrayOf(R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        val adapter = MyAdapter(this, mTitle, mDescription, images)
        listView.setAdapter(adapter)

        //If user selects any of the meals, open and pass data to Food Activity
        listView.setOnItemClickListener(OnItemClickListener { adapterView, view, position, id ->
            if (position == 0) {
                val intent = Intent(applicationContext, Food::class.java)
                //Pass data from food1 to "Food" activity
                val bundle = Bundle()
                bundle.putInt("image", images[0])
                intent.putExtras(bundle)

                //Title and Description inside Food Activity
                intent.putExtra("title", mTitle[0])
                intent.putExtra("description", mDescription[0])
                intent.putExtra("ingredients", mIngredients[0])
                intent.putExtra("instructions", mInsructions[0])

                //Position
                intent.putExtra("position", +0)
                startActivity(intent)
            }
            if (position == 1) {
                val intent = Intent(applicationContext, Food::class.java)
                val bundle = Bundle()
                bundle.putInt("image", images[1])
                intent.putExtras(bundle)
                intent.putExtra("title", mTitle[1])
                intent.putExtra("description", mDescription[1])
                intent.putExtra("ingredients", mIngredients[1])
                intent.putExtra("instructions", mInsructions[1])

                //Position
                intent.putExtra("position", +1)
                startActivity(intent)
            }
            if (position == 2) {
                val intent = Intent(applicationContext, Food::class.java)
                val bundle = Bundle()
                bundle.putInt("image", images[2])
                intent.putExtras(bundle)
                intent.putExtra("title", mTitle[2])
                intent.putExtra("description", mDescription[2])
                intent.putExtra("ingredients", mIngredients[2])
                intent.putExtra("instructions", mInsructions[2])

                //Position
                intent.putExtra("position", +2)
                startActivity(intent)
            }
            if (position == 3) {
                val intent = Intent(applicationContext, Food::class.java)
                val bundle = Bundle()
                bundle.putInt("image", images[3])
                intent.putExtras(bundle)
                intent.putExtra("title", mTitle[3])
                intent.putExtra("description", mDescription[3])
                intent.putExtra("ingredients", mIngredients[3])
                intent.putExtra("instructions", mInsructions[3])

                //Position
                intent.putExtra("position", +3)
                startActivity(intent)
            }
        })
    }

    internal inner class MyAdapter(
        var context: Context,
        var rTitle: Array<String>,
        var rDescription: Array<String>,
        var rImgs: IntArray
    ) : ArrayAdapter<String?>(
        context, R.layout.row, R.id.textView1, rTitle
    ) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater =
                applicationContext.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row = layoutInflater.inflate(R.layout.row, parent, false)
            val images = row.findViewById<ImageView>(R.id.image)
            val myTitle = row.findViewById<TextView>(R.id.textView1)
            val myDescription = row.findViewById<TextView>(R.id.textView2)
            images.setImageResource(rImgs[position])
            myTitle.text = rTitle[position]
            myDescription.text = rDescription[position]
            return row
        }
    }

    //Menu Navigation
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mymenu, menu)
        return true
    }

    //Menu Item Selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.item2 -> {
                val intent2 = Intent(this, ShoppingList::class.java)
                startActivity(intent2)
            }
            R.id.item3 -> {
                //DialogFragment
                val a_builder = AlertDialog.Builder(this@MainActivity)
                a_builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, which -> finishAffinity() }
                    .setNegativeButton("No") { dialog, which -> dialog.cancel() }
                val alert = a_builder.create()
                alert.setTitle("Exit")
                alert.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}