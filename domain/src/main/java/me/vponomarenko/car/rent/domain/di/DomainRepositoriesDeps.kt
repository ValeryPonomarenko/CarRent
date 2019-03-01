package me.vponomarenko.car.rent.domain.di

import me.vponomarenko.car.rent.domain.repositories.ICarsRepository

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DomainRepositoriesDeps {
    fun getCarsRepository(): ICarsRepository
}