package com.giftech.academy.di

import android.content.Context
import com.giftech.academy.data.source.AcademyRepository
import com.giftech.academy.data.source.remote.RemoteDataSource
import com.giftech.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}