package com.example.moodtracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.R



var imagearray = intArrayOf(
    R.drawable.angry,R.drawable.down,R.drawable.confuse,R.drawable.happy,
    R.drawable.happiness,R.drawable.noidea,R.drawable.sad,R.drawable.screwedup,
    R.drawable.sorry
)

val strings: Array<String> = arrayOf("angry","down","confuse","happy","happiness","no idea","sad","screwed up","sorry")

class MoodSelectAdapter(
) : RecyclerView.Adapter<MoodSelectAdapter.MoodSelectHolder>() {

    class MoodSelectHolder(private val view: View): RecyclerView.ViewHolder(view){
        val getview : View = view
        val image : ImageButton = view.findViewById(R.id.selectmood)
        val text : TextView = view.findViewById(R.id.moodscript)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodSelectHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.moodselect_row, parent, false)

        return MoodSelectHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MoodSelectHolder, position: Int) {
        val item = imagearray[position]

        holder.image.setImageResource(item)
        holder.image.setOnClickListener{
            val bundle = bundleOf("mood" to position)
            holder.getview.findNavController().navigate(R.id.action_mood_select_to_text_mood, bundle)
            //Navigation.findNavController(holder.getview).navigate(R.id.action_mood_select_to_text_mood)
        }
        holder.text.text = strings[position]

    }

    override fun getItemCount(): Int {
        return imagearray.size
    }
}