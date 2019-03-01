package me.vponomarenko.car.rent.domain.usecases

import io.reactivex.Single
import me.vponomarenko.car.rent.domain.entities.CarInfo
import me.vponomarenko.car.rent.domain.repositories.ICarsRepository

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class GetCarsUseCase(private val repository: ICarsRepository) {
    operator fun invoke(): Single<List<CarInfo>> = repository.getCars()
}