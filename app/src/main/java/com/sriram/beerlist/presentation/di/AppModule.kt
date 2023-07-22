package com.sriram.beerlist.presentation.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.sriram.beerlist.data.database.BeerDataBase
import com.sriram.beerlist.data.database.BeerEntity
import com.sriram.beerlist.data.remote.API
import com.sriram.beerlist.data.remote.BASE_URL
import com.sriram.beerlist.data.repository.BeerRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerDataBase(@ApplicationContext context: Context): BeerDataBase {
        return Room.databaseBuilder(
            context,
            BeerDataBase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAPI(): API {
        val logger = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logger).build()
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beerDataBase: BeerDataBase, beerAPI: API): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = BeerRemoteMediator(
                beerDataBase,
                beerAPI
            ),
            pagingSourceFactory = {
                beerDataBase.dao.pagingSource()
            }
        )
    }
}