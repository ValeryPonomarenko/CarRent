package me.vponomarenko.car.rent.map.viewstate

import me.vponomarenko.car.rent.domain.entities.CarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class MapViewState {
    object Loading : MapViewState()
    data class Loaded(val cars: List<CarInfo>) : MapViewState()
    data class Error(val message: String) : MapViewState()
}