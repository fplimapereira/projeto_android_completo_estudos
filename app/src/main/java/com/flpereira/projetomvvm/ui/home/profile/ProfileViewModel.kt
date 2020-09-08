package com.flpereira.projetomvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import com.flpereira.projetomvvm.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()
}