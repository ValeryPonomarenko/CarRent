package me.vponomarenko.car.rent.map.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.car.rent.common.di.SchedulerModule
import me.vponomarenko.car.rent.common.di.ViewModelKey
import me.vponomarenko.car.rent.map.viewmodel.MapViewModel

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module(includes = [SchedulerModule::class])
internal class MapModule {
    @Provides
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    fun provideViewModel(viewModel: MapViewModel): ViewModel = viewModel
}