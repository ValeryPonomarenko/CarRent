package me.vponomarenko.car.rent.carslist.di

import me.vponomarenko.car.rent.carslist.navigation.CarsListViewNavigation
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface CarsListDeps {
    fun getToolbarDecorationConsumer(): ToolbarDecorationConsumer
    fun getCarsListViewNavigation(): CarsListViewNavigation
}