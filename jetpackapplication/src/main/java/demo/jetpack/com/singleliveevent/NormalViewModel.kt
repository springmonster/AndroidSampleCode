package demo.jetpack.com.singleliveevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Charles.Kuang
 */
class NormalViewModel : ViewModel() {
    private val _navigate = MutableLiveData<Boolean>()

    val navigate: LiveData<Boolean>
        get() = _navigate

    fun onClick() {
        _navigate.value = true
    }
}
