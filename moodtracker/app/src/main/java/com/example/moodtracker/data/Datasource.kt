package com.example.moodtracker.data
import com.example.moodtracker.R
import com.example.moodtracker.model.MoodtrackerModel

class Datasource {
    fun load(): List<MoodtrackerModel> {
        return listOf<MoodtrackerModel>(
            MoodtrackerModel(R.string.affirmation1),
            MoodtrackerModel(R.string.affirmation2),
            MoodtrackerModel(R.string.affirmation3),
            MoodtrackerModel(R.string.affirmation4),
            MoodtrackerModel(R.string.affirmation5),
            MoodtrackerModel(R.string.affirmation6),
            MoodtrackerModel(R.string.affirmation7),
            MoodtrackerModel(R.string.affirmation8),
            MoodtrackerModel(R.string.affirmation9),
            MoodtrackerModel(R.string.affirmation10)
        )
    }
}