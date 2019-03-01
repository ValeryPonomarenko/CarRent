package me.vponomarenko.car.rent.data.entities

import android.net.Uri

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal data class CarEntity(
    val id: String,
    val modelIdentifier: String,
    val modelName: String,
    val name: String,
    val make: String,
    val group: String,
    val color: String,
    val series: String,
    val fuelType: String,
    val fuelLevel: Float,
    val transmission: String,
    val licensePlate: String,
    val latitude: Float,
    val longitude: Float,
    val innerCleanliness: String,
    val carImageUrl: Uri
)