package me.vponomarenko.car.rent.data.di.qualifiers

import javax.inject.Qualifier

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoScheduler(val value: String = "IoScheduler")