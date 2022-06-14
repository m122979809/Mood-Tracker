package com.example.moodtracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.R

var image = intArrayOf(
    R.drawable.angry,R.drawable.down,R.drawable.down,R.drawable.happy,
    R.drawable.happy,R.drawable.angry,R.drawable.sad,R.drawable.angry,
    R.drawable.happy,R.drawable.happy
)

val message = mutableListOf<String>().apply(){
    add("I am strong.")
    add("I believe in myself.")
    add("Each day is a new opportunity to grow and be a better version of myself.")
    add("Every challenge in my life is an opportunity to learn from.")
    add("I have so much to be grateful for.")
    add("Good things are always coming into my life.")
    add("New opportunities await me at every turn.")
    add("I have the courage to follow my heart.")
    add("Things will unfold at precisely the right time.")
    add("I will be present in all the moments that this day brings.")
}

val date = mutableListOf<String>().apply(){
    add("6/13")
    add("6/14")
    add("6/13")
    add("6/14")
    add("6/13")
    add("6/13")
    add("6/14")
    add("6/12")
    add("6/14")
    add("6/13")
}

class ShareAdapter(
) : RecyclerView.Adapter<ShareAdapter.ShareHolder>() {

    class ShareHolder(private val view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView5)
        val text : TextView = view.findViewById(R.id.textView11)
        val text2 : TextView = view.findViewById(R.id.textView13)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShareHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.other_row, parent, false)

        return ShareHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ShareHolder, position: Int) {
        holder.image.setImageResource(image[position])
        holder.text.text = message[position]
        holder.text2.text = date[position]
    }

    override fun getItemCount(): Int {
        return message.size
    }
}