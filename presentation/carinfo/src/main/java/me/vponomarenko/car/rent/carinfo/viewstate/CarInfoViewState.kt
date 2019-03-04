package me.vponomarenko.car.rent.carinfo.viewstate

import me.vponomarenko.car.rent.domain.entities.FullCarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal sealed class CarInfoViewState {
    object Loading : CarInfoViewState()
    data class Loaded(val car: FullCarInfo) : CarInfoViewState()
    data class Error(val error: String) : CarInfoViewState()
}