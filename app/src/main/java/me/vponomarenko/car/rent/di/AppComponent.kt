package me.vponomarenko.car.rent.di

import dagger.Component
import me.vponomarenko.car.rent.MainActivity
import me.vponomarenko.car.rent.carinfo.di.CarInfoDeps
import me.vponomarenko.car.rent.carslist.di.CarsListDeps
import me.vponomarenko.car.rent.map.di.MapDeps
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : MapDeps, CarsListDeps, CarInfoDeps {

    companion object {
        fun init(): AppComponent = DaggerAppComponent.create()
    }

    fun inject(activity: MainActivity)
}