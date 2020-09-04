package com.example.william_mavuso_180256_recipeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditDataActivity : AppCompatActivity() {
    private var btnSave: Button? = null
    private var btnDelete: Button? = null
    private var editText: EditText? = null
    var myDB: DatabaseHelper? = null
    private var selectedName: String? = null
    private var selectedID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_data_layout)

        //ActionBar
        supportActionBar!!.title = "Update Ingredients"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        btnSave = findViewById<View>(R.id.btnSave) as Button
        btnDelete = findViewById<View>(R.id.btnDelete) as Button
        editText = findViewById<View>(R.id.editText) as EditText
        myDB = DatabaseHelper(this)

        //Get the intent extra from ViewListContents
        val info = intent

        //itemID extra
        selectedID = info.getIntExtra("id", -1)

        //name extra
        selectedName = info.getStringExtra("name")

        //sets text to show the current selected name
        editText!!.setText(selectedName)


        //When user clicks Delete or Save
        btnSave!!.setOnClickListener {
            val item = editText!!.text.toString()
            if (item != "") {
                myDB!!.updateName(item, selectedID, selectedName)
            } else {
                toastMessage("You must enter a item")
            }
        }
        btnDelete!!.setOnClickListener {
            myDB!!.deleteName(selectedID, selectedName)
            editText!!.setText("")
            toastMessage("Item has been removed")
        }
    }

    //All toast messages
    private fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "EditDataActivity"
    }
}