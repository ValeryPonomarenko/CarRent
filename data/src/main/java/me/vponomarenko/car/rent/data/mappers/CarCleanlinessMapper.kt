package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.domain.entities.CarCleanliness
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarCleanlinessMapper @Inject constructor() {
    fun map(cleanliness: String) =
        when (cleanliness.capitalize()) {
            "REGULAR" -> CarCleanliness.REGULAR
            "CLEAN" -> CarCleanliness.CLEAN
            "VERY_CLEAN" -> CarCleanliness.VERY_CLEAN
            else -> throw IllegalStateException("Unknown cleanliness $cleanliness")
        }
}