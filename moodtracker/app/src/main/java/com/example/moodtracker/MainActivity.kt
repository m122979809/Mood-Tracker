package com.example.moodtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import com.example.moodtracker.databinding.ActivityMainBinding
import com.google.firebase.Timestamp
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toast.makeText(this, Timestamp.now().toString(), Toast.LENGTH_SHORT).show()

        //val myDataset = Datasource().load()

        /*val recyclerView = findViewById<RecyclerView>(R.id.WholeMoodRecyclerView)
        recyclerView.adapter = ItemAdapter(this, myDataset )

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)*/
    }
}