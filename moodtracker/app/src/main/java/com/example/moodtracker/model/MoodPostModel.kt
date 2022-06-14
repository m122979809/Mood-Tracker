package com.example.moodtracker.model

import com.google.firebase.Timestamp
import java.util.*

data class MoodPostModel(
    val uid: String? = null,
    val mood: String? = null,
    val text: String? = null,
    val timestamp: Long = 0
)
