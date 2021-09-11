package com.giftech.academy.di

import android.content.Context
import com.giftech.academy.utils.AppExecutors
import com.giftech.academy.utils.JsonHelper
import com.giftech.academy.data.AcademyRepository
import com.giftech.academy.data.source.local.LocalDataSource
import com.giftech.academy.data.source.local.room.AcademyDatabase
import com.giftech.academy.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
