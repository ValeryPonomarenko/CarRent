package me.vponomarenko.car.rent.carslist.navigation

import me.vponomarenko.car.rent.common.CommonViewNavigation

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface CarsListViewNavigation : CommonViewNavigation {
    fun openCarInfo(carId: String)
}