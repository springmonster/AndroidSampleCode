package com.constraintlayoutexamples

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_6.*

class MainActivity : AppCompatActivity() {
    var isMainLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMainViews()
    }

    private fun initMainViews() {
        setContentView(R.layout.activity_main)

        val list = mutableListOf<RvViewEntity>()
        list.apply {
            add(RvViewEntity("Simple", R.layout.layout_1))
            add(RvViewEntity("Guide", R.layout.layout_2))
            add(RvViewEntity("Barrier", R.layout.layout_3))
            add(RvViewEntity("ConstraintSet", Int.MAX_VALUE))
            add(RvViewEntity("Margin", R.layout.layout_4))
            add(RvViewEntity("Group", R.layout.layout_5))
            add(RvViewEntity("PlaceHolder", R.layout.layout_6))
            add(RvViewEntity("PlaceHolder2", R.layout.layout_7))
        }
        val adapter = RvAdapter()
        adapter.setOnRvItemClick(object : RvAdapter.OnRvItemClick {
            override fun onClick(id: Int) {
                if (id != Int.MAX_VALUE) {
                    isMainLayout = false
                    setContentView(id)
                } else {
                    startActivity(Intent(this@MainActivity, ConstraintSetActivity::class.java))
                }
            }
        })

        activity_main_rv.adapter = adapter
        activity_main_rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(list)
    }

    override fun onBackPressed() {
        if (!isMainLayout) {
            val intent = Intent()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setClass(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        } else {
            super.onBackPressed()
        }
    }

    fun swipeView(view: View) {
        TransitionManager.beginDelayedTransition(layout_6_cl)
        placeholder.setContentId(view.id)
    }
}
