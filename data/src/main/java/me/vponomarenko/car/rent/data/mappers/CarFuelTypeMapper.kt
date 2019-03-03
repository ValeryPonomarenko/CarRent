package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.domain.entities.CarFuelType
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarFuelTypeMapper @Inject constructor() {
    fun map(fuelType: String) =
        when (fuelType.capitalize()) {
            "P" -> CarFuelType.PETROL
            "D" -> CarFuelType.DIESEL
            "E" -> CarFuelType.ELECTRIC
            else -> throw IllegalStateException("Unknown fuel type $fuelType")
        }
}