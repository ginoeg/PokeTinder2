package tecsup.edu.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tecsup.edu.poketinder.util.SharedPreferenceUtil
import tecsup.edu.poketinder.data.model.User

class LoginViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyEmailError = MutableLiveData<Boolean>()
    val emptyPasswordError = MutableLiveData<Boolean>()
    val fieldsAuthenricateError = MutableLiveData<Boolean>()
    val goalSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferenceUtil= SharedPreferenceUtil().also{
            it.setSharedPreference(context)
        }
    }

    fun validateInputs( email: String, password:String){
        //validateInput()
        if(email.isEmpty()){
            emptyEmailError.postValue(true)
        }else if(password.isEmpty()){
            emptyPasswordError.postValue(true)
        }else {
            val user: User? = sharedPreferenceUtil.getUser()

            if (user?.email.equals(email) && user?.password.equals(password)) {
                goalSuccesActivity.postValue(true)
            } else {
                fieldsAuthenricateError.postValue(true)
            }
        }
    }
}