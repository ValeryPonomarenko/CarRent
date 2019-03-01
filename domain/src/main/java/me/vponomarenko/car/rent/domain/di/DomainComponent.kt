package me.vponomarenko.car.rent.domain.di

import dagger.Component
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainRepositoriesDeps::class],
    modules = [DomainModule::class]
)
interface DomainComponent : DomainApi