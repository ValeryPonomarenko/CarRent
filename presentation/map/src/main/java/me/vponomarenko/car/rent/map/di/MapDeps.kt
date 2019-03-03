package me.vponomarenko.car.rent.map.di

import me.vponomarenko.car.rent.map.navigation.MapViewNavigation

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface MapDeps {
    fun getMapViewNavigation(): MapViewNavigation
}