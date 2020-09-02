package com.flpereira.projetomvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.flpereira.projetomvvm.R
import com.flpereira.projetomvvm.data.db.entities.User
import com.flpereira.projetomvvm.databinding.ActivityLoginBinding
import com.flpereira.projetomvvm.util.hide
import com.flpereira.projetomvvm.util.show
import com.flpereira.projetomvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding= DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSucess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}