package com.example.core3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.with as with1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val olympicsLists = findViewById<RecyclerView>(R.id.olympicslist)

        val data = mutableListOf<medalrecord>()

        val readfile = resources.openRawResource(R.raw.medallists).bufferedReader()

        readfile.readLine() //mainly because its a header, that it can be passed or ignored
        readfile.forEachLine {
            val temp = it.split(",")
            val countryrecord = medalrecord(temp[0], temp[1], temp[2].toInt(), temp[3].toInt(), temp[4].toInt(), temp[5].toInt())
            data.add(countryrecord)
        }
        Log.i("SIZE", data.size.toString())

        olympicsLists.adapter = adaptor(data){showon(it)}
        olympicsLists.layoutManager = LinearLayoutManager(this)
    }
    fun showon(item:medalrecord)
    {
        val sharepref = this.getSharedPreferences("data", Context.MODE_PRIVATE) ?: return
        sharepref.edit().apply{
            putString("name",item.country)
            putString("code",item.ioccode)

        } .apply()

        /*val text = item.country + " has completed " +item.timescompeted+" times in the olympics and won " + item.gold + " gold, " + item.silver + " silver, " + item.bronze
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()*/

        botfragpass(item)
    }

    private fun botfragpass(item:medalrecord): bottomfrag//https://stackoverflow.com/questions/46551228/how-to-pass-and-get-value-from-fragment-and-activity
    {

        val botfrag = bottomfrag()
        val bundle = Bundle()
        bundle.putSerializable("data",item)
        botfrag.arguments = bundle
        botfrag.show(supportFragmentManager, "BottomSheetDialog")
        return botfrag
    }

        //https://developer.android.com/guide/topics/ui/menus
    //https://developer.android.com/guide/topics/resources/menu-resource
    //this is to indicate that the menu is going to be used
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true

    }

    //this shows what happen if the menu is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)
        {
            R.id.LastClick ->{
                val transfer = Intent(this, DetailActivity::class.java)
                startActivity(transfer)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}