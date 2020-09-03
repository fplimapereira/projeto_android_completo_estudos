package com.flpereira.projetomvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.flpereira.projetomvvm.data.repositories.UserRepository
import com.flpereira.projetomvvm.util.ApiException
import com.flpereira.projetomvvm.util.Coroutines

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = UserRepository().userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSucess(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }


        }



    }
}