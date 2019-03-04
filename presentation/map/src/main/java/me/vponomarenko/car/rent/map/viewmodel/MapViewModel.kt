package me.vponomarenko.car.rent.map.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
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

    private var disposable: Disposable? = null

    init {
        initLoading()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun onCarsListClicked() {
        mapViewNavigation.openCarsList()
    }

    fun onCarClicked(carId: String) {
        mapViewNavigation.openCarInfo(carId)
    }

    private fun initLoading() {
        disposable?.dispose()
        _viewState.value = MapViewState.Loading
        disposable =
            getCarsUseCase()
                .observeOn(uiScheduler)
                .subscribe({
                    _viewState.value = MapViewState.Loaded(it)
                }, {
                    _viewState.value = MapViewState.Error(it.toString())
                })
    }
}