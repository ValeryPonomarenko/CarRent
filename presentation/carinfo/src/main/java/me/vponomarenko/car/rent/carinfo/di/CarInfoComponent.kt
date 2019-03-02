package me.vponomarenko.car.rent.carinfo.di

import dagger.BindsInstance
import dagger.Component
import me.vponomarenko.car.rent.carinfo.view.CarInfoFragment
import me.vponomarenko.car.rent.domain.di.DomainApi
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
    modules = [CarInfoModule::class]
)
interface CarInfoComponent {

    companion object {
        fun init(carId: String): CarInfoComponent =
            DaggerCarInfoComponent
                .builder()
                .carId(carId)
                .domainApi(XInjectionManager.findComponent())
                .build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun carId(id: String): Builder

        fun domainApi(domainApi: DomainApi): Builder

        fun build(): CarInfoComponent
    }

    fun inject(fragment: CarInfoFragment)
}