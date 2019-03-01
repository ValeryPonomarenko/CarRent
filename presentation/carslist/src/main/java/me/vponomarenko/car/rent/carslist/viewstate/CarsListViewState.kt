package me.vponomarenko.car.rent.carslist.viewstate

import me.vponomarenko.car.rent.domain.entities.CarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class CarsListViewState {
    object LOADING : CarsListViewState()
    data class Loaded(val carsList: List<CarInfo>) : CarsListViewState()
    data class Error(val error: String) : CarsListViewState()
}