package com.example.moodtracker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moodtracker.databinding.FragmentForgetPwdBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPWActivity : AppCompatActivity() {

    private lateinit var binding: FragmentForgetPwdBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentForgetPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.button2.setOnClickListener {
            firebaseAuth.sendPasswordResetEmail(binding.editTextTextEmailAddress.text.toString()).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Reset password has been sent to  !", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, it.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}