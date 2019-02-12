package demo.jetpack.com.singleliveevent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import demo.jetpack.com.R
import kotlinx.android.synthetic.main.activity_single_live_event.*

class SingleLiveEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_live_event)

        val vm = ViewModelProviders.of(this).get(SingleLiveEventViewModel::class.java)
        vm.navigationDetails.observe(this, Observer {
            startActivity(Intent(this@SingleLiveEventActivity, SingleLiveEventDetailActivity::class.java))
        })
        activity_sle_btn.setOnClickListener {
            vm.userClicksButton()
        }
    }
}
