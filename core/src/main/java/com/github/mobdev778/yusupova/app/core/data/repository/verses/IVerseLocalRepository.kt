package com.github.mobdev778.yusupova.app.core.data.repository.verses

import com.github.mobdev778.yusupova.app.core.domain.entities.verses.Book
import com.github.mobdev778.yusupova.app.core.domain.entities.verses.Verse

interface IVerseLocalRepository {

    fun getBooks(): List<Book>

    fun saveBooks(books: List<Book>)

    fun getVerses(bookId: Int): List<Verse>

    fun getVerse(verseId: Int): Verse

    fun getVerseIds(): List<Int>

}