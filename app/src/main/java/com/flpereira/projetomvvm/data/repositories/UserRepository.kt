package com.flpereira.projetomvvm.data.repositories

import com.flpereira.projetomvvm.data.network.MyApi
import com.flpereira.projetomvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse>{
        return MyApi().userLogin(email, password)
    }
}