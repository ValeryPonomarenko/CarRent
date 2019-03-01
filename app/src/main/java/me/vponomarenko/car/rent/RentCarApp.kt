package me.vponomarenko.car.rent

import android.app.Application
import me.vponomarenko.car.rent.data.di.DaggerDataComponent
import me.vponomarenko.car.rent.data.di.DataComponent
import me.vponomarenko.car.rent.domain.di.DaggerDomainComponent
import me.vponomarenko.car.rent.domain.di.DomainComponent
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class RentCarApp : Application() {

    override fun onCreate() {
        super.onCreate()
        with(XInjectionManager) {
            bindComponent(object : IHasComponent<DataComponent> {
                override fun getComponent() = DaggerDataComponent.create()
            })
            bindComponent(object : IHasComponent<DomainComponent> {
                override fun getComponent() =
                    DaggerDomainComponent
                        .builder()
                        .domainRepositoriesDeps(findComponent())
                        .build()
            })
        }
    }
}