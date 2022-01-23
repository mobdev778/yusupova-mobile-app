package com.github.mobdev778.yusupova.app.core.domain.entities.verses

data class Book(
    val id: Int,
    val title: String,
    val verses: List<Verse>  // may be empty
)