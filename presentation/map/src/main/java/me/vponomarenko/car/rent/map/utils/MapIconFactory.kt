package me.vponomarenko.car.rent.map.utils

import me.vponomarenko.car.rent.domain.entities.CarInfo
import org.osmdroid.views.overlay.OverlayItem

/**
 * Author: Valery Ponomarenko
 * Date: 04/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class MapIconFactory(private val geoPointMapper: GeoPointMapper) {
    fun create(car: CarInfo): OverlayItem =
        OverlayItem(car.id, car.modelName, car.name, geoPointMapper.map(car.latitude, car.longitude))
}