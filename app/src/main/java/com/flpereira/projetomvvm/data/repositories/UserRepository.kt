package com.flpereira.projetomvvm.data.repositories

import com.flpereira.projetomvvm.data.network.MyApi
import com.flpereira.projetomvvm.data.network.SafeApiRequest
import com.flpereira.projetomvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository: SafeApiRequest(){

    suspend fun userLogin(email: String, password: String): AuthResponse{
        return apiRequest {MyApi().userLogin(email, password)}
    }
}