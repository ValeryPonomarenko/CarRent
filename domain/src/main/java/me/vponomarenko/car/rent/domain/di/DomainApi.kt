package me.vponomarenko.car.rent.domain.di

import me.vponomarenko.car.rent.domain.usecases.GetCarsUseCase
import me.vponomarenko.car.rent.domain.usecases.GetFullCarInfoUseCase

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DomainApi {
    fun getCarsUseCase(): GetCarsUseCase
    fun getFullCarInfoUseCase(): GetFullCarInfoUseCase
}