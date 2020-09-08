package com.flpereira.projetomvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flpereira.projetomvvm.data.repositories.UserRepository


class ProfileViewlModelFactory(
    private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}