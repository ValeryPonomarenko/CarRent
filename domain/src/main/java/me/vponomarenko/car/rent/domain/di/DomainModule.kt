package me.vponomarenko.car.rent.domain.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.car.rent.domain.repositories.ICarsRepository
import me.vponomarenko.car.rent.domain.usecases.GetCarsUseCase
import me.vponomarenko.car.rent.domain.usecases.GetFullCarInfoUseCase
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class DomainModule {
    @Singleton
    @Provides
    fun provideGetCarsUse(repository: ICarsRepository): GetCarsUseCase =
        GetCarsUseCase(repository)

    @Singleton
    @Provides
    fun provideGetFullCarInfoUseCase(repository: ICarsRepository): GetFullCarInfoUseCase =
        GetFullCarInfoUseCase(repository)
}