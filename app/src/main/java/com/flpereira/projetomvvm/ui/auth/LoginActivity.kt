package com.flpereira.projetomvvm.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.flpereira.projetomvvm.R
import com.flpereira.projetomvvm.data.db.AppDataBase
import com.flpereira.projetomvvm.data.db.entities.User
import com.flpereira.projetomvvm.data.network.MyApi
import com.flpereira.projetomvvm.data.repositories.UserRepository
import com.flpereira.projetomvvm.databinding.ActivityLoginBinding
import com.flpereira.projetomvvm.ui.home.HomeActivity
import com.flpereira.projetomvvm.util.hide
import com.flpereira.projetomvvm.util.show
import com.flpereira.projetomvvm.util.snackbar
import com.flpereira.projetomvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = MyApi()
        val db = AppDataBase(this)
        val repository = UserRepository(api, db)
        val factory = AuthViewModelFactory(repository)

        val binding : ActivityLoginBinding= DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer{ user ->
            if (user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSucess(user: User) {
        progress_bar.hide()
        //root_layout.snackbar("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}