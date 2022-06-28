package tecsup.edu.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tecsup.edu.poketinder.data.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {
    private var firesbaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init{
        firesbaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance(): MutableLiveData<Boolean> {
        return firesbaseRemoteConfigRepository.isUnderMaintenanceLiveData
    }

}