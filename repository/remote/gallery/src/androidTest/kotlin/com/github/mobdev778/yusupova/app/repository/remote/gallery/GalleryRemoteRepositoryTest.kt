package com.github.mobdev778.yusupova.app.repository.remote.gallery

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mobdev778.yusupova.app.core.data.repository.gallery.IGalleryRemoteRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class GalleryRemoteRepositoryTest {

    @Inject
    lateinit var repository: IGalleryRemoteRepository

    @Before
    fun setup() {
        val component: RemoteTestComponent = DaggerRemoteTestComponent.builder().build()
        component.inject(this)
    }

    @Test
    fun testGetPictures() {
        runBlocking {
            val pictures = repository.getPictures()
            assertThat("Pictures number should be greater than 0", pictures.size > 0)
        }
    }

    @Test
    fun testGetPicture() {
        runBlocking {
            val pictures = repository.getPictures()
            val pictureFile = repository.getPicture(pictures[0].path)
            assertThat("Picture file should be existed", pictureFile.exists())
            assertThat("Picture file should have non-zero length", pictureFile.length() > 0)
        }
    }

}