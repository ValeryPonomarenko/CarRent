package me.vponomarenko.car.rent.common

import androidx.appcompat.widget.Toolbar

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ToolbarDecorationConsumer {
    fun decorate(action: Toolbar.() -> Unit)
}