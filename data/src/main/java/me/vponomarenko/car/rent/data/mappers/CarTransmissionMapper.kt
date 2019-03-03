package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.domain.entities.CarTransmission
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarTransmissionMapper @Inject constructor() {
    fun map(transmission: String) =
        if (transmission == "A") CarTransmission.AUTOMATIC else CarTransmission.MANUAL
}