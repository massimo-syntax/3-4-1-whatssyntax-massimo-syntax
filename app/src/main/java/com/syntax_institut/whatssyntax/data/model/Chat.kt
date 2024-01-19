package com.syntax_institut.whatssyntax.data.model

data class Chat(
    val contact: Contact,
    var messages: MutableList<Message>
)