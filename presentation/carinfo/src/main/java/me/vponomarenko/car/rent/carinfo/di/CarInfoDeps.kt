package me.vponomarenko.car.rent.carinfo.di

import me.vponomarenko.car.rent.common.CommonViewNavigation
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface CarInfoDeps {
    fun getToolbarDecorationConsumer(): ToolbarDecorationConsumer
    fun getCommonViewNavigation(): CommonViewNavigation
}