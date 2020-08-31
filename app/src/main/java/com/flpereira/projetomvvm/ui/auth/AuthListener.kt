package com.flpereira.projetomvvm.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSucess()
    fun onFailure(message: String)
}