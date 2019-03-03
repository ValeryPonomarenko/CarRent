package me.vponomarenko.car.rent.carslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import me.vponomarenko.car.rent.carslist.navigation.CarsListViewNavigation
import me.vponomarenko.car.rent.carslist.viewstate.CarsListViewState
import me.vponomarenko.car.rent.common.di.qualifiers.UiScheduler
import me.vponomarenko.car.rent.domain.usecases.GetCarsUseCase
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarsListViewModel @Inject constructor(
    @UiScheduler private val uiScheduler: Scheduler,
    private val getCarsUseCase: GetCarsUseCase,
    private val carsListViewNavigation: CarsListViewNavigation
) : ViewModel() {

    val viewState: LiveData<CarsListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<CarsListViewState>()

    private var disposable: Disposable? = null

    init {
        initLoading()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun onCarClick(carId: String) {
        carsListViewNavigation.openCarInfo(carId)
    }

    fun goBack() {
        carsListViewNavigation.goBack()
    }

    private fun initLoading() {
        _viewState.value = CarsListViewState.LOADING
        disposable?.dispose()
        disposable =
            getCarsUseCase()
                .observeOn(uiScheduler)
                .subscribe({
                    _viewState.value = CarsListViewState.Loaded(it)
                }, {
                    _viewState.value = CarsListViewState.Error(it.toString())
                })
    }
}