package me.vponomarenko.car.rent.common.di.qualifiers

import javax.inject.Qualifier

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UiScheduler(val value: String = "UiScheduler")