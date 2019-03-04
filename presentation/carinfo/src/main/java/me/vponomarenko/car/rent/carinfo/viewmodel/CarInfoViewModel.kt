package me.vponomarenko.car.rent.carinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import me.vponomarenko.car.rent.carinfo.viewstate.CarInfoViewState
import me.vponomarenko.car.rent.common.CommonViewNavigation
import me.vponomarenko.car.rent.common.di.qualifiers.UiScheduler
import me.vponomarenko.car.rent.domain.usecases.GetFullCarInfoUseCase
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarInfoViewModel @Inject constructor(
    private val carId: String,
    @UiScheduler private val uiScheduler: Scheduler,
    private val getFullCarInfoUseCase: GetFullCarInfoUseCase,
    private val commonViewNavigation: CommonViewNavigation
) : ViewModel() {

    val viewState: LiveData<CarInfoViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<CarInfoViewState>()

    private var disposable: Disposable? = null

    init {
        initLoading()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun goBack() {
        commonViewNavigation.goBack()
    }

    private fun initLoading() {
        disposable?.dispose()
        disposable =
            getFullCarInfoUseCase(carId)
                .observeOn(uiScheduler)
                .subscribe({
                    _viewState.value = CarInfoViewState.Loaded(it)
                }, {
                    _viewState.value = CarInfoViewState.Error(it.toString())
                })
    }
}