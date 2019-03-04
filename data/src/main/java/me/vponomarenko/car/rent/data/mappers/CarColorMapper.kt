package me.vponomarenko.car.rent.data.mappers

import android.graphics.Color
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarColorMapper @Inject constructor() {

    private val colors = arrayOf(
        Color.BLACK,
        Color.BLUE,
        Color.CYAN,
        Color.DKGRAY,
        Color.GREEN,
        Color.LTGRAY,
        Color.MAGENTA,
        Color.RED,
        Color.YELLOW
    )

    fun map(color: String): Int {
        val colorIndex = color.getOrElse(0) { 'a' }.toInt() % colors.size
        return colors[colorIndex]
    }
}