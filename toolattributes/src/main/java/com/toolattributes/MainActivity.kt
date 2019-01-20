package com.toolattributes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Item>()
        list.apply {
            add(Item("", "163", "163 full 163 full 163 full", "this is 163 address", "2000-10-10"))
        }
        val adapter = Adapter()
        adapter.submitList(list)
        activity_rv.adapter = adapter
    }
}
