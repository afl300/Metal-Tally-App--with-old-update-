package com.example.core3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import kotlin.with as with1

class bottomfrag : BottomSheetDialogFragment() {//https://www.youtube.com/watch?v=yqnVPiWAw0o
    //https://www.geeksforgeeks.org/how-to-send-data-from-activity-to-fragment-in-android/
   //this is to set up variables that is going to be used
    private lateinit var medaldata: medalrecord
    private lateinit var countryfrag: TextView
    private lateinit var ioccodefrag: TextView
    private lateinit var timescompete:TextView
    private lateinit var goldno :TextView
    private lateinit var silverno:TextView
    private lateinit var bronzeno:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {//https://karshan77.medium.com/findviewbyid-in-fragment-in-android-d15fc3da2058
        //need to set up a view variable then set it out how its used and how to grab the data
        var fragview = inflater.inflate(R.layout.bottomfrag,container,false)
        countryfrag = fragview.findViewById(R.id.countryfrag)
        ioccodefrag = fragview.findViewById(R.id.ioccodefrag)
        timescompete = fragview.findViewById(R.id.timescompete)
        goldno = fragview.findViewById(R.id.goldno)
        silverno = fragview.findViewById(R.id.silverno)
        bronzeno = fragview.findViewById(R.id.bronzeno)
        //this is to set variables
        countryfrag.text = medaldata.country
        ioccodefrag.text = medaldata.ioccode
        timescompete.text = "Times Compete: " + medaldata.timescompeted.toString()
        goldno.text = medaldata.gold.toString()
        silverno.text=medaldata.silver.toString()
        bronzeno.text=medaldata.bronze.toString()
        return fragview
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if(bundle!=null)
        {
            medaldata = bundle.get("data") as medalrecord
        }
    }

}