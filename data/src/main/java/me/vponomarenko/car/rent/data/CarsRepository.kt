package me.vponomarenko.car.rent.data

import io.reactivex.Scheduler
import io.reactivex.Single
import me.vponomarenko.car.rent.data.di.qualifiers.IoScheduler
import me.vponomarenko.car.rent.data.mappers.CarEntityToCarInfo
import me.vponomarenko.car.rent.data.mappers.CarEntityToFullCarInfo
import me.vponomarenko.car.rent.domain.entities.CarInfo
import me.vponomarenko.car.rent.domain.entities.FullCarInfo
import me.vponomarenko.car.rent.domain.repositories.ICarsRepository
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarsRepository @Inject constructor(
    private val api: SixtAPI,
    @IoScheduler private val ioScheduler: Scheduler,
    private val carEntityToCarInfoMapper: CarEntityToCarInfo,
    private val carEntityToFullCarInfoMapper: CarEntityToFullCarInfo
) : ICarsRepository {
    override fun getCars(): Single<List<CarInfo>> =
        api.getCars()
            .subscribeOn(ioScheduler)
            .map(carEntityToCarInfoMapper::map)

    override fun getCarInfo(id: String): Single<FullCarInfo> =
        api.getCars()
            .subscribeOn(ioScheduler)
            .flatMap { cars ->
                val car = cars.find { it.id == id }
                return@flatMap if (car != null) {
                    Single.just(car)
                } else {
                    Single.error(IllegalStateException("The car with id = $id was not found"))
                }
            }
            .map(carEntityToFullCarInfoMapper::map)
}