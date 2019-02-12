package demo.jetpack.com.singleliveevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * @author Charles.Kuang
 */
class SingleLiveEventViewModel : ViewModel() {
    private val _navigationDetails = SingleLiveEvent<Boolean>()

    val navigationDetails: LiveData<Boolean>
        get() = _navigationDetails

    fun userClicksButton() {
        _navigationDetails.call()
    }
}