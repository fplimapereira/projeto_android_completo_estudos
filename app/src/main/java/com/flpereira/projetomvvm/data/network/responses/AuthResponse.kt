package com.flpereira.projetomvvm.data.network.responses

import com.flpereira.projetomvvm.data.db.entities.User

data class AuthResponse(
    val isSucessful: Boolean?,
    val message: String?,
    val user: User?
)
