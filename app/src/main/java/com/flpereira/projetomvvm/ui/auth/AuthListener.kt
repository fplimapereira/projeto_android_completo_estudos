package com.flpereira.projetomvvm.ui.auth


import com.flpereira.projetomvvm.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSucess(user: User)
    fun onFailure(message: String)
}