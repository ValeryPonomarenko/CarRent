package me.vponomarenko.car.rent.carslist.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.car.rent.carslist.recyclerview.CarsListAdapter
import me.vponomarenko.car.rent.carslist.viewmodel.CarsListViewModel
import me.vponomarenko.car.rent.common.di.SchedulerModule
import me.vponomarenko.car.rent.common.di.ViewModelKey
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module(includes = [SchedulerModule::class])
internal class CarsListModule {
    @Provides
    @IntoMap
    @ViewModelKey(CarsListViewModel::class)
    fun provideViewModel(viewModel: CarsListViewModel): ViewModel = viewModel

    @Singleton
    @Provides
    fun provideCarsListAdapter(): CarsListAdapter = CarsListAdapter()
}