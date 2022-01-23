package com.github.mobdev778.yusupova.app.repository.remote.verses

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mobdev778.yusupova.app.core.data.repository.verses.IVerseRemoteRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class VersesRemoteRepositoryTest {

    @Inject
    lateinit var repository: IVerseRemoteRepository

    @Before
    fun setup() {
        val component: RemoteTestComponent = DaggerRemoteTestComponent.builder().build()
        component.inject(this)
    }

    @Test
    fun testGetVerses() {
        runBlocking {
            val bookShelf = repository.getBookShelf()

            val version = bookShelf.version
            assertThat("Versions should be greater than 0", version > 0)

            val books = bookShelf.books
            assertThat("Books number should be greater than 0", books.size > 0)
        }
    }

}