package me.vponomarenko.car.rent.domain.usecases

import io.reactivex.Single
import me.vponomarenko.car.rent.domain.entities.FullCarInfo
import me.vponomarenko.car.rent.domain.repositories.ICarsRepository

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class GetFullCarInfoUseCase(private val repository: ICarsRepository) {
    operator fun invoke(id: String): Single<FullCarInfo> = repository.getCarInfo(id)
}