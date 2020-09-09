package com.flpereira.projetomvvm.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flpereira.projetomvvm.data.repositories.QuoteRepository


class QuotesViewModelFactory(
    private val repository: QuoteRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(repository) as T
    }
}