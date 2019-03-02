package me.vponomarenko.car.rent.carinfo.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.car.rent.carinfo.viewmodel.CarInfoViewModel
import me.vponomarenko.car.rent.common.di.SchedulerModule
import me.vponomarenko.car.rent.common.di.ViewModelKey

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module(includes = [SchedulerModule::class])
internal class CarInfoModule {
    @Provides
    @IntoMap
    @ViewModelKey(CarInfoViewModel::class)
    fun provideViewModel(viewModel: CarInfoViewModel): ViewModel = viewModel
}