package com.example.core3

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val sharepref = this.getSharedPreferences("data", Context.MODE_PRIVATE)
        val country = sharepref.getString("name", "Australia").toString()
        val ioccode = sharepref.getString("code", "AUS").toString()

        val TextViewResult = findViewById<TextView>(R.id.result)
        TextViewResult.text = "The last Country clicked was $country ($ioccode)"

    }
}