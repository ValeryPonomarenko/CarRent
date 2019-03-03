package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.data.entities.CarEntity
import me.vponomarenko.car.rent.domain.entities.FullCarInfo
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarEntityToFullCarInfo @Inject constructor() {
    fun map(carEntities: List<CarEntity>): List<FullCarInfo> = carEntities.map(this::map)

    private fun map(carEntity: CarEntity): FullCarInfo =
        FullCarInfo(
            id = carEntity.id,
            modelName = carEntity.modelName,
            latitude = carEntity.latitude,
            longitude = carEntity.longitude,
            carImageUrl = carEntity.carImageUrl
        )
}