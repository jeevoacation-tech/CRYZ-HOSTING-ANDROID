package com.cryzhosting.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(28, 52, 28, 28)
            setBackgroundColor(Color.rgb(12, 16, 27))
        }
        fun label(value: String, size: Float, color: Int, bold: Boolean = false) =
            TextView(this).apply {
                text = value
                textSize = size
                setTextColor(color)
                gravity = Gravity.CENTER
                if (bold) typeface = Typeface.DEFAULT_BOLD
                setPadding(0, 10, 0, 10)
            }
        fun fullWidth() = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        root.addView(label("CRYZ HOSTING", 28f, Color.WHITE, true), fullWidth())
        root.addView(label("YOUR WORLD. YOUR SERVER.", 12f, Color.LTGRAY), fullWidth())

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 24, 20, 24)
            setBackgroundColor(Color.rgb(24, 31, 48))
        }
        val cardParams = fullWidth().apply { topMargin = 36 }
        root.addView(card, cardParams)
        card.addView(label("MY BEDROCK SERVER", 18f, Color.WHITE, true), fullWidth())
        card.addView(label("Status: Not running", 14f, Color.LTGRAY), fullWidth())

        card.addView(Button(this).apply {
            text = "START SERVER"
            setOnClickListener {
                Toast.makeText(this@MainActivity,
                    "Demo only — the Bedrock server engine is not connected yet.",
                    Toast.LENGTH_LONG).show()
            }
        }, fullWidth())

        root.addView(Button(this).apply {
            text = "CREATE SERVER"
            setOnClickListener {
                Toast.makeText(this@MainActivity,
                    "Server creation is coming next.", Toast.LENGTH_SHORT).show()
            }
        }, fullWidth())

        root.addView(label(
            "EARLY BUILD • BEDROCK • DEMO CONTROLS",
            11f, Color.GRAY
        ), fullWidth())

        setContentView(root)
    }
}
