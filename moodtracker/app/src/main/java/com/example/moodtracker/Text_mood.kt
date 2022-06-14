package com.example.moodtracker

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moodtracker.model.MoodPostModel
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Text_mood.newInstance] factory method to
 * create an instance of this fragment.
 */
class Text_mood : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_text_mood, container, false)
        view.findViewById<ImageButton>(R.id.imageButton0).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_text_mood_to_mood_select)
            readFireBase()
        }
        view.findViewById<ImageButton>(R.id.imageButton1).setOnClickListener {
            val uid = FirebaseAuth.getInstance().currentUser!!.uid
            val mood = view.findViewById<TextView>(R.id.textView9).text.toString()
            val text = view.findViewById<TextView>(R.id.detail_mood).text.toString().encode()
            saveFireBase(uid, mood, text)
            Navigation.findNavController(view).navigate(R.id.action_text_mood_to_others_mood)
        }
        when (arguments?.getInt("mood")) {
            0->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.angry)
                view.findViewById<TextView>(R.id.textView9).text = "angry"
            }
            1->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.down)
                view.findViewById<TextView>(R.id.textView9).text = "down"
            }
            2->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.confuse)
                view.findViewById<TextView>(R.id.textView9).text = "confuse"
            }
            3->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.happy)
                view.findViewById<TextView>(R.id.textView9).text = "happy"
            }
            4->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.happiness)
                view.findViewById<TextView>(R.id.textView9).text = "happiness"
            }
            5->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.noidea)
                view.findViewById<TextView>(R.id.textView9).text = "no idea"
            }
            6->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.sad)
                view.findViewById<TextView>(R.id.textView9).text = "sad"
            }
            7->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.screwedup)
                view.findViewById<TextView>(R.id.textView9).text = "screwed up"
            }
            8->{
                view.findViewById<ImageView>(R.id.imageView4).setImageResource(R.drawable.sorry)
                view.findViewById<TextView>(R.id.textView9).text = "sorry"
            }
        }
        return  view
    }

    fun saveFireBase(uid: String, mood: String, text: String){

        val db = FirebaseDatabase.getInstance("https://mood-tracker-6798a-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("MoodPosts")
        val sharing = MoodPostModel(uid, mood, text, Timestamp.now().seconds)
        var id = db.push().key
        db.child(id!!).setValue(sharing)
            .addOnCompleteListener{
                Toast.makeText(this.context, "Added to DB succesfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{ Toast.makeText(this.context, "Failed to add data to DB", Toast.LENGTH_SHORT).show() }

    }

    fun readFireBase(){

        val db = FirebaseDatabase.getInstance("https://mood-tracker-6798a-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("MoodPosts")
        db.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.e("cancel", error.toString())
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<MoodPostModel>()
                for (data in snapshot.children){
                    var model = data.getValue(MoodPostModel::class.java)
                    list.add(model as MoodPostModel)
                    //Log.d("sharing", model.text!!.decode())
                }
            }


        })
    }

    fun String.decode(): String {
        return Base64.decode(this, Base64.DEFAULT).toString(charset("UTF-8"))
    }

    fun String.encode(): String {
        return Base64.encodeToString(this.toByteArray(charset("UTF-8")), Base64.DEFAULT)
    }

//    fun saveFireStore(mood: String, text: String) {
//        val db = FirebaseFirestore.getInstance()
//        val sharing: MutableMap<String, String> = HashMap()
//        sharing["uid"] = FirebaseAuth.getInstance().currentUser!!.uid
//        sharing["lastName"] = Base64.encodeToString(text.toByteArray(), Base64.DEFAULT)
//
//        db.collection("sharings")
//            .add(sharing)
//            .addOnSuccessListener {
//                Toast.makeText(this.context, "record added successfully ", Toast.LENGTH_SHORT ).show()
//            }
//            .addOnFailureListener{
//                Toast.makeText(this.context, "record Failed to add ", Toast.LENGTH_SHORT ).show()
//            }
//    }

//    fun readFireStoreData() {
//        val db = FirebaseFirestore.getInstance()
//        db.collection("users")
//            .get()
//            .addOnCompleteListener {
//
//                val result: StringBuffer = StringBuffer()
//
//                if(it.isSuccessful) {
//                    for(document in it.result!!) {
//                        result.append(document.data.getValue("firstName")).append(" ")
//                            .append(document.data.getValue("lastName")).append("\n\n")
//                    }
//                    textViewResult.setText(result)
//                }
//            }
//
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Text_mood.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Text_mood().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}