package me.vponomarenko.car.rent.di

import dagger.Component
import me.vponomarenko.car.rent.MainActivity
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
interface AppComponent {

    companion object {
        fun init(): AppComponent = DaggerAppComponent.create()
    }

    fun inject(activity: MainActivity)
}