package me.vponomarenko.car.rent.data

import io.reactivex.Single
import me.vponomarenko.car.rent.data.entities.CarEntity
import retrofit2.http.GET

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal interface SixtAPI {
    @GET("cars")
    fun getCars(): Single<List<CarEntity>>
}