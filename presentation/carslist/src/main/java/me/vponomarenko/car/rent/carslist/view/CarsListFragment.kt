package me.vponomarenko.car.rent.carslist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_cars_list.*
import me.vponomarenko.car.rent.carslist.R
import me.vponomarenko.car.rent.carslist.di.CarsListComponent
import me.vponomarenko.car.rent.carslist.viewmodel.CarsListViewModel
import me.vponomarenko.car.rent.carslist.viewstate.CarsListViewState
import me.vponomarenko.car.rent.common.di.ViewModelFactory
import me.vponomarenko.car.rent.common.observe
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarsListFragment : Fragment(), IHasComponent<CarsListComponent> {

    companion object {
        private const val NEW_LINE = "\n"
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(CarsListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.bindComponent(this).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cars_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(this) {
            when (it) {
                is CarsListViewState.Loaded ->
                    text_carsList.text = it.carsList.joinToString(separator = NEW_LINE) { it.id }
            }
        }
    }

    override fun getComponent() = CarsListComponent.init()
}