package com.flpereira.projetomvvm.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.flpereira.projetomvvm.data.repositories.QuoteRepository
import com.flpereira.projetomvvm.util.lazyDeferred

class QuotesViewModel(repository: QuoteRepository) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}