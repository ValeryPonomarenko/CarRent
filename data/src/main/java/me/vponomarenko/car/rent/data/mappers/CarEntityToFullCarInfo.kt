package me.vponomarenko.car.rent.data.mappers

import me.vponomarenko.car.rent.data.entities.CarEntity
import me.vponomarenko.car.rent.domain.entities.FullCarInfo
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarEntityToFullCarInfo @Inject constructor(
    private val carCleanlinessMapper: CarCleanlinessMapper,
    private val carFuelTypeMapper: CarFuelTypeMapper,
    private val carTransmissionMapper: CarTransmissionMapper,
    private val carColorMapper: CarColorMapper
) {
    fun map(carEntity: CarEntity): FullCarInfo =
        FullCarInfo(
            id = carEntity.id,
            modelIdentifier = carEntity.modelIdentifier,
            modelName = carEntity.modelName,
            name = carEntity.name,
            make = carEntity.make,
            color = carColorMapper.map(carEntity.color),
            series = carEntity.series,
            fuelType = carFuelTypeMapper.map(carEntity.fuelType),
            fuelLevel = carEntity.fuelLevel,
            transmission = carTransmissionMapper.map(carEntity.transmission),
            licensePlate = carEntity.licensePlate,
            latitude = carEntity.latitude,
            longitude = carEntity.longitude,
            innerCleanliness = carCleanlinessMapper.map(carEntity.innerCleanliness),
            carImageUrl = carEntity.carImageUrl
        )
}