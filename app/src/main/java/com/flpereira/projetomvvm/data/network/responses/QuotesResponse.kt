package com.flpereira.projetomvvm.data.network.responses

import com.flpereira.projetomvvm.data.db.entities.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)