package com.flpereira.projetomvvm

import android.app.Application
import com.flpereira.projetomvvm.data.db.AppDataBase
import com.flpereira.projetomvvm.data.network.MyApi
import com.flpereira.projetomvvm.data.network.NetworkConnectionInterceptor
import com.flpereira.projetomvvm.data.repositories.UserRepository
import com.flpereira.projetomvvm.ui.auth.AuthViewModelFactory
import com.flpereira.projetomvvm.ui.home.profile.ProfileViewlModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewlModelFactory(instance()) }
    }

}