package com.example.core3

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adaptor(private val data: List<medalrecord>, private val listener: (medalrecord)-> Unit): RecyclerView.Adapter<adaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptor.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: adaptor.ViewHolder, position: Int) {
        val item = data[position] //this is to grab the data mainly
        holder.bind(item)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) { //this takes a view e.g row, store the textviews in the row
        private val total: TextView = v.findViewById(R.id.totalmedals) //this is the total medals
        private val ioccode: TextView = v.findViewById(R.id.ioc) //this is the total medals
        private val countryname: TextView = v.findViewById(R.id.country) //this is the total medals

        fun bind(item: medalrecord) {
            val totalmedal = item.bronze + item.silver + item.gold
            total.text = totalmedal.toString()
            ioccode.text = item.ioccode
            countryname.text = item.country
            val timescompete = item.timescompeted
                Log.i("countrycode", item.timescompeted.toString())
                if(timescompete>=10) //this is to see how many competed 10 or more olympics but havent won a gold or silver medal
                {
                    countryname.setTextColor(-16711681 )

                    total.setTextColor(-16711681 )

                    ioccode.setTextColor(-16711681 )
                }
                else
                {
                    countryname.setTextColor(-3355444    )

                    total.setTextColor(-3355444    )

                    ioccode.setTextColor(-3355444   )
                }
                Log.i("countrycode", item.ioccode)
                if (item.silver<item.gold)
                {/*https://developer.android.com/reference/android/graphics/Color*/
                    countryname.setTextColor(-25500)

                    total.setTextColor(-25500)

                    ioccode.setTextColor(-25500)
                }
                else if (item.gold<item.silver)
                {
                    countryname.setTextColor(-910570198)

                    total.setTextColor(-910570198)

                    ioccode.setTextColor(-910570198)
                }



            //this is now clicking the entire row rather than the name, issue with this is it needs a context
            v.setOnClickListener()
            {
                listener(item)
            }
        }

    }
}