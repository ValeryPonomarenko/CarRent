package me.vponomarenko.car.rent.carslist.di

import dagger.Component
import me.vponomarenko.car.rent.carslist.view.CarsListFragment
import me.vponomarenko.car.rent.domain.di.DomainApi
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainApi::class],
    modules = [CarsListModule::class]
)
interface CarsListComponent {

    companion object {
        fun init(): CarsListComponent =
            DaggerCarsListComponent.builder()
                .domainApi(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: CarsListFragment)
}