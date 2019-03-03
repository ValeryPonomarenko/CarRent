package me.vponomarenko.car.rent.carslist.viewstate

import me.vponomarenko.car.rent.domain.entities.CarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal sealed class CarsListViewState {
    object Loading : CarsListViewState()
    data class Loaded(val carsList: List<CarInfo>) : CarsListViewState()
    data class Error(val error: String) : CarsListViewState()
}