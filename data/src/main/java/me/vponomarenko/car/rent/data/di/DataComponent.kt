package me.vponomarenko.car.rent.data.di

import dagger.Component
import me.vponomarenko.car.rent.domain.di.DomainRepositoriesDeps
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(modules = [DataModule::class])
interface DataComponent : DomainRepositoriesDeps