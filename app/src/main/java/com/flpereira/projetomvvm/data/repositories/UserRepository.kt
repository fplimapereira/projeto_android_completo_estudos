package com.flpereira.projetomvvm.data.repositories

import com.flpereira.projetomvvm.data.db.AppDataBase
import com.flpereira.projetomvvm.data.db.entities.User
import com.flpereira.projetomvvm.data.network.MyApi
import com.flpereira.projetomvvm.data.network.SafeApiRequest
import com.flpereira.projetomvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(private val api: MyApi,
                     private val db: AppDataBase): SafeApiRequest(){

    suspend fun userLogin(email: String, password: String): AuthResponse{
        return apiRequest {api.userLogin(email, password)}
    }

    suspend fun userSignup(name: String, email: String, password: String): AuthResponse{
        return apiRequest { api.userSignup(name, email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()
}