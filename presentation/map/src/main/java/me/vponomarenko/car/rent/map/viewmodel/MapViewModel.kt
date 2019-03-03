package me.vponomarenko.car.rent.map.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import me.vponomarenko.car.rent.common.di.qualifiers.UiScheduler
import me.vponomarenko.car.rent.domain.usecases.GetCarsUseCase
import me.vponomarenko.car.rent.map.navigation.MapViewNavigation
import me.vponomarenko.car.rent.map.viewstate.MapViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MapViewModel @Inject constructor(
    @UiScheduler private val uiScheduler: Scheduler,
    private val getCarsUseCase: GetCarsUseCase,
    private val mapViewNavigation: MapViewNavigation
) : ViewModel() {

    val viewState: LiveData<MapViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<MapViewState>()

    fun onCarsListClicked() {
        mapViewNavigation.openCarsList()
    }
}