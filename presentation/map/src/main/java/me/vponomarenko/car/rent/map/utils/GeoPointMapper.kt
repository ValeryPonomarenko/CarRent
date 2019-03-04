package me.vponomarenko.car.rent.map.utils

import org.osmdroid.util.GeoPoint

/**
 * Author: Valery Ponomarenko
 * Date: 04/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class GeoPointMapper {
    fun map(latitude: Float, longitude: Float): GeoPoint = GeoPoint(latitude.toDouble(), longitude.toDouble())
}