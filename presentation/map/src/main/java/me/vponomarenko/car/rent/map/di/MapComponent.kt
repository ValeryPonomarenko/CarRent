package me.vponomarenko.car.rent.map.di

import dagger.Component
import me.vponomarenko.car.rent.domain.di.DomainApi
import me.vponomarenko.car.rent.map.view.MapFragment
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainApi::class],
    modules = [MapModule::class]
)
interface MapComponent {

    companion object {
        fun init(): MapComponent =
            DaggerMapComponent
                .builder()
                .domainApi(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: MapFragment)
}