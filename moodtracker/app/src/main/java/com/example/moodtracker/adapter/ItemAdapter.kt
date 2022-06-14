package com.example.moodtracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.R


val stringlist = mutableListOf<String>().apply(){
    add("6/1")
    add("6/2")
    add("6/3")
    add("6/4")
    add("6/5")
    add("6/6")
    add("6/7")
    add("6/8")
    add("6/9")
    add("6/10")
    add("6/11")
    add("6/12")
    add("6/13")
    add("6/14")
}

class ItemAdapter(
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.textView5)
        val image1 : ImageButton = view.findViewById(R.id.mood1)
        val image2 : ImageButton = view.findViewById(R.id.mood2)
        val image3 : ImageButton = view.findViewById(R.id.mood3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.mood_recyclerview_row, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = stringlist[position]
        holder.textView.text =  item
        when (position) {
            0->{
                holder.image1.setImageResource(R.drawable.nomood)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            1->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            2->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            3->{
                holder.image1.setImageResource(R.drawable.confuse)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.nomood)
            }
            4->{
                holder.image1.setImageResource(R.drawable.down)
                holder.image2.setImageResource(R.drawable.down)
                holder.image3.setImageResource(R.drawable.happiness)
            }
            5->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            6->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            7->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happiness)
                holder.image3.setImageResource(R.drawable.nomood)
            }
            8->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            9->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            10->{
                holder.image1.setImageResource(R.drawable.nomood)
                holder.image2.setImageResource(R.drawable.nomood)
                holder.image3.setImageResource(R.drawable.nomood)
            }
            11->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.happy)
            }
            12->{
                holder.image1.setImageResource(R.drawable.angry)
                holder.image2.setImageResource(R.drawable.angry)
                holder.image3.setImageResource(R.drawable.angry)
            }
            13->{
                holder.image1.setImageResource(R.drawable.happy)
                holder.image2.setImageResource(R.drawable.happy)
                holder.image3.setImageResource(R.drawable.nomood)
            }
        }
    }

    override fun getItemCount(): Int {
        return stringlist.size
    }
}