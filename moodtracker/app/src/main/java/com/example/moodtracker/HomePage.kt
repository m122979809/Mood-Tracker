package com.example.moodtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.adapter.ItemAdapter
import com.example.moodtracker.data.Datasource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [HomePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        view.findViewById<ImageView>(R.id.add_new_mood).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_homePage_to_mood_select) }
        view.findViewById<ImageButton>(R.id.report1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_homePage_to_report) }
        view.findViewById<ImageButton>(R.id.share1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_homePage_to_others_mood) }
        view.findViewById<ImageButton>(R.id.setting1).setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_homePage_to_setting) }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview1)
        recyclerView.adapter = ItemAdapter()
        recyclerView.setHasFixedSize(true)
        return  view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}