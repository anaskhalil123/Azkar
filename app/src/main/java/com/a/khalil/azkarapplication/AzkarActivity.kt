package com.a.khalil.azkarapplication

import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a.khalil.azkarapplication.DB.DB
import com.a.khalil.azkarapplication.databinding.ActivityAzkarBinding
import com.a.khalil.azkarapplication.model.Theker


class AzkarActivity : AppCompatActivity() {

    val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    lateinit var azkar: Array<Array<Any>>
    private val TAG = "AzkarActivity"
    lateinit var database: DB
    lateinit var toolBar: Toolbar
    lateinit var binding: ActivityAzkarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAzkarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = DB(this)

        val azakarClass = intent.getIntExtra("azkarClass", 0)
        val azakarClassName = intent.getStringExtra("name")

        if (azakarClass != 0)
            azkar = database.getThekersForClass(azakarClass)

        Log.d(TAG, "$azkar")
        binding.recyclerView.adapter = ThekerAdapter(this, azkar)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.toolbarText.text = azakarClassName
    }
}