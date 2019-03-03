package me.vponomarenko.car.rent.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.car.rent.navigator.AppNavigator
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class AppModule {
    @Singleton
    @Provides
    fun provideAppNavigator(): AppNavigator = AppNavigator()
}