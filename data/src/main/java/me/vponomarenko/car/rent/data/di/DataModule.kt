package me.vponomarenko.car.rent.data.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.car.rent.data.CarsRepository
import me.vponomarenko.car.rent.data.SixtAPI
import me.vponomarenko.car.rent.data.di.qualifiers.IoScheduler
import me.vponomarenko.car.rent.domain.repositories.ICarsRepository
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class DataModule {

    companion object {
        private const val API_URL = "https://cdn.sixt.io/codingtask/"
    }

    @Singleton
    @Provides
    fun provideRepositoryInterface(repository: CarsRepository): ICarsRepository = repository

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideConverterGson(): Converter.Factory = GsonConverterFactory.create(GsonBuilder().create())

    @Singleton
    @Provides
    fun provideAdapterRxJava(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    @IoScheduler
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    @Singleton
    @Provides
    fun provideSixtApi(
        client: OkHttpClient,
        converterGson: Converter.Factory,
        adapterRxJava: CallAdapter.Factory
    ): SixtAPI =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(converterGson)
            .addCallAdapterFactory(adapterRxJava)
            .build()
            .create(SixtAPI::class.java)
}