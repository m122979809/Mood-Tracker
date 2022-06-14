package com.example.moodtracker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moodtracker.databinding.FragmentLoginPageBinding
import com.example.moodtracker.databinding.LoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginPageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.sign.setOnClickListener {
            val email = binding.ETemail.text.toString()
            val pass = binding.ETpassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        firebaseAuth.currentUser!!.sendEmailVerification()
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("user_id", firebaseAuth.currentUser?.uid)
                        intent.putExtra("user_email", firebaseAuth.currentUser?.email)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.login.setOnClickListener {
            val email = binding.ETemail.text.toString()
            val pass = binding.ETpassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("user_id", firebaseAuth.currentUser?.uid)
                        intent.putExtra("user_email", firebaseAuth.currentUser?.email)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.forgetPwd.setOnClickListener {
            startActivity(Intent(this, ForgetPWActivity::class.java))
        }
        binding.skip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}