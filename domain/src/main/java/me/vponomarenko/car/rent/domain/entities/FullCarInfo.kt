package me.vponomarenko.car.rent.domain.entities

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class FullCarInfo(
    val id: String,
    val modelIdentifier: String,
    val modelName: String,
    val name: String,
    val make: String,
    val color: Int,
    val series: String,
    val fuelType: CarFuelType,
    val fuelLevel: Float,
    val transmission: CarTransmission,
    val licensePlate: String,
    val latitude: Float,
    val longitude: Float,
    val innerCleanliness: CarCleanliness,
    val carImageUrl: String
)