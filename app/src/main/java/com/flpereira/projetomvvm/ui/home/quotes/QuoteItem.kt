package com.flpereira.projetomvvm.ui.home.quotes

import com.flpereira.projetomvvm.R
import com.flpereira.projetomvvm.data.db.entities.Quote
import com.flpereira.projetomvvm.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(private val quote: Quote): BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}