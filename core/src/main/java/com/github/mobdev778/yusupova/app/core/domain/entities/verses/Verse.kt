package com.github.mobdev778.yusupova.app.core.domain.entities.verses

data class Verse(
    val id: Int,
    val title: String,
    val lines: List<String>
)