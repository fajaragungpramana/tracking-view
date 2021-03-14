package com.github.fajaragungpramana.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf(
            Destination(
                "Pos A",
                "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"
            ),
            Destination(
                "Pos B",
                "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"
            ),
            Destination(
                "Pos C",
                "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"
            ),
            Destination(
                "Pos D",
                "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"
            ),
            Destination(
                "Pos E",
                "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy"
            )
        )

        findViewById<RecyclerView>(R.id.rv_destination).let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = DestinationAdapter(data)
        }

    }

}