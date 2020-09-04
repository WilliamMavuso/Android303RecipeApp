package com.example.william_mavuso_180256_recipeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.william_mavuso_180256_recipeapp.ShoppingList

class ShoppingList : MainActivity() {
    var myDB: DatabaseHelper? = null
    var btnAdd: Button? = null
    var btnView: Button? = null
    var editText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.additem)
        editText = findViewById<View>(R.id.editText) as EditText
        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        btnView = findViewById<View>(R.id.btnView) as Button
        myDB = DatabaseHelper(this)
        btnView!!.setOnClickListener {
            val intent = Intent(this@ShoppingList, ViewListContents::class.java)
            startActivity(intent)
        }
        btnAdd!!.setOnClickListener { //EditText Error Check
            val newEntry = editText!!.text.toString()
            if (editText!!.length() != 0) {
                AddData(newEntry)
                editText!!.setText("")
            } else {
                Toast.makeText(
                    this@ShoppingList,
                    "You must put something in the text field",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun AddData(newEntry: String) {
        val insertData = myDB!!.addData(newEntry)
        //When user adds an entry
        if (insertData == true) {
            Toast.makeText(this@ShoppingList, "Ingredient Added!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@ShoppingList, "Please validate input", Toast.LENGTH_LONG).show()
        }
    }
}