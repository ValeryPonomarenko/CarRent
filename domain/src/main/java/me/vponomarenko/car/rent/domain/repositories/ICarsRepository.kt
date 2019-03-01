package me.vponomarenko.car.rent.domain.repositories

import io.reactivex.Single
import me.vponomarenko.car.rent.domain.entities.CarInfo
import me.vponomarenko.car.rent.domain.entities.FullCarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ICarsRepository {
    fun getCars(): Single<List<CarInfo>>
    fun getCarInfo(id: String): Single<FullCarInfo>
}