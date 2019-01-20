package com.constraintlayoutexamples

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

/**
 * xml中的控件Id要相同
 */
class ConstraintSetActivity : AppCompatActivity() {
    var isNormalLayout = true
    var mRootLayout: ConstraintLayout? = null

    val constraintSet1 = ConstraintSet()
    val constraintSet2 = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set_1)

        mRootLayout = findViewById(R.id.activity_constraintset_cl)

        constraintSet1.load(this, R.layout.activity_constraint_set_1)
        constraintSet2.load(this, R.layout.activity_constraint_set_2)
    }

    fun toggleMode(view: View) {
        TransitionManager.beginDelayedTransition(mRootLayout)
        isNormalLayout = !isNormalLayout
        if (isNormalLayout) {
            constraintSet1.applyTo(mRootLayout)
        } else {
            constraintSet2.applyTo(mRootLayout)
        }
    }
}
