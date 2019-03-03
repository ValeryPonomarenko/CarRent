package me.vponomarenko.car.rent.domain.entities

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class CarInfo(
    val id: String,
    val modelName: String,
    val latitude: Float,
    val longitude: Float,
    val carImageUrl: String
)