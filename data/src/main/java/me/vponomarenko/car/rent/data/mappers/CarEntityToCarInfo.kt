package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.data.entities.CarEntity
import me.vponomarenko.car.rent.domain.entities.CarInfo
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarEntityToCarInfo @Inject constructor() {
    fun map(carEntities: List<CarEntity>): List<CarInfo> = carEntities.map(this::map)

    private fun map(carEntity: CarEntity): CarInfo =
        CarInfo(
            id = carEntity.id,
            modelName = carEntity.modelName,
            name = carEntity.name,
            latitude = carEntity.latitude,
            longitude = carEntity.longitude,
            carImageUrl = carEntity.carImageUrl
        )
}