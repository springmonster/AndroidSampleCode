package demo.jetpack.com.singleliveevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_normal.*

class NormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        val normalViewModel = ViewModelProviders.of(this).get(NormalViewModel::class.java)

        normal_activity_mb.setOnClickListener {
            normalViewModel.onClick()
        }

        normalViewModel.navigate.observe(this, Observer {
            if (it) {
                startActivity(Intent(this@NormalActivity, NormalDetailActivity::class.java))
            }
        })
    }
}
