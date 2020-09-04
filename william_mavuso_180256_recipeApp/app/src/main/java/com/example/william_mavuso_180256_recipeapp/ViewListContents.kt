package com.example.william_mavuso_180256_recipeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.william_mavuso_180256_recipeapp.ViewListContents
import java.util.*

class ViewListContents : AppCompatActivity() {
    var myDB: DatabaseHelper? = null
    private var mListView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        supportActionBar!!.title = "My Ingredients"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        mListView = findViewById<View>(R.id.listView) as ListView
        myDB = DatabaseHelper(this)
        populateListView()
    }

    private fun populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.")
        //get the data and append to a list
        val data = myDB.getData()
        val listData = ArrayList<String>()
        while (data!!.moveToNext()) {
            //get the value from the database in column 1
            //then add item to the ArrayList
            listData.add(data!!.getString(1))
        }
        //list adapter
        val adapter: ListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listData)
        mListView!!.adapter = adapter

        //onItemClickListener to the ListView
        mListView!!.onItemClickListener = OnItemClickListener { adapterView, view, i, l ->
            val name = adapterView.getItemAtPosition(i).toString()
            Log.d(TAG, "onItemClick: You Clicked on $name")


            //Get the ID associated with that name
            val data = myDB!!.getItemID(name)
            var itemID = -1
            while (data!!.moveToNext()) {
                itemID = data.getInt(0)
            }
            if (itemID > 0) {
                Log.d(TAG, "onItemClick: The ID is: $itemID")
                //Go to editDataActivity
                val editScreenIntent = Intent(this@ViewListContents, EditDataActivity::class.java)
                editScreenIntent.putExtra("id", itemID)
                editScreenIntent.putExtra("name", name)
                startActivity(editScreenIntent)
            } else {
                toastMessage("No ID associated with that name")
            }
        }
    }

    //All toast messages
    private fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "ViewListContents"
    }
}