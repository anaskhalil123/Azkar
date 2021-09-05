package com.a.khalil.azkarapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val btnFirst: Button by lazy { findViewById(R.id.btnFirst) }
    private val btnEvening: Button by lazy { findViewById(R.id.btnEvening) }
    private val btnSleep: Button by lazy { findViewById(R.id.btnSleep) }
    var btnName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.statusBarColor)

        btnFirst.setOnClickListener(this)
        btnEvening.setOnClickListener(this)
        btnSleep.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent: Intent
        when (view!!.id) {
            R.id.btnFirst -> {
                btnName = btnFirst.text.toString()
                intent = Intent(this, AzkarActivity::class.java).putExtra("btnName", btnName)
            }
            R.id.btnEvening -> {
                btnName = btnEvening.text.toString()
                intent = Intent(this, AzkarActivity::class.java).putExtra("btnName", btnName)
            }
            R.id.btnSleep -> {
                btnName = btnSleep.text.toString()
                intent = Intent(this, AzkarActivity::class.java).putExtra("btnName", btnName)
            }
            else -> throw IllegalArgumentException("Unknown Button")
        }
        startActivity(intent)
    }

}