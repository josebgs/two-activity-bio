package com.bignerdranch.android.twoactivitybio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private const val DISPLAY_KEY ="com.bignerdranch.android.twoactivitybio.display_key"

class DisplayActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        displayTextView = findViewById(R.id.display_text_view)
        val displayText = intent.getStringExtra(DISPLAY_KEY)
        displayTextView.text = displayText
    }

    companion object {
        fun newIntent(packageContext: Context, message: String): Intent {
            return Intent(packageContext, DisplayActivity::class.java).apply{
                putExtra(DISPLAY_KEY, message)
            }
        }
    }
}