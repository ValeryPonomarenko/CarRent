package me.vponomarenko.car.rent.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.car.rent.carslist.navigation.CarsListViewNavigation
import me.vponomarenko.car.rent.common.CommonViewNavigation
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer
import me.vponomarenko.car.rent.decorators.ToolbarDecorator
import me.vponomarenko.car.rent.map.navigation.MapViewNavigation
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
    fun provideToolbarDecorator(): ToolbarDecorator = ToolbarDecorator()

    @Singleton
    @Provides
    fun provideToolbarDecorationConsumer(toolbarDecorator: ToolbarDecorator): ToolbarDecorationConsumer =
        toolbarDecorator

    @Singleton
    @Provides
    fun provideAppNavigator(): AppNavigator = AppNavigator()

    @Singleton
    @Provides
    fun provideCommonViewNavigation(appNavigator: AppNavigator): CommonViewNavigation = appNavigator

    @Singleton
    @Provides
    fun provideMapViewNavigation(appNavigator: AppNavigator): MapViewNavigation = appNavigator

    @Singleton
    @Provides
    fun provideCarsListViewNavigation(appNavigator: AppNavigator): CarsListViewNavigation = appNavigator
}