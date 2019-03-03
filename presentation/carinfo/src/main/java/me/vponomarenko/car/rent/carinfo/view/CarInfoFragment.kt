package me.vponomarenko.car.rent.carinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import me.vponomarenko.car.rent.carinfo.R
import me.vponomarenko.car.rent.carinfo.di.CarInfoComponent
import me.vponomarenko.car.rent.carinfo.viewmodel.CarInfoViewModel
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer
import me.vponomarenko.car.rent.common.di.ViewModelFactory
import me.vponomarenko.car.rent.common.disableToolbarBackButton
import me.vponomarenko.car.rent.common.enableToolbarBackButton
import me.vponomarenko.car.rent.common.observe
import me.vponomarenko.car.rent.common.setTitle
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CarInfoFragment : Fragment(), IHasComponent<CarInfoComponent> {

    companion object {
        private const val EXTRA_CAR_ID = "extra.car_info.car_id"

        fun newInstance(carId: String) =
            CarInfoFragment().apply {
                arguments = Bundle().apply { putString(EXTRA_CAR_ID, carId) }
            }
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var toolbarDecorationConsumer: ToolbarDecorationConsumer

    private val carId: String by lazy {
        arguments?.getString(EXTRA_CAR_ID) ?: throw IllegalStateException("carId is null")
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(CarInfoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.bindComponent(this).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_car_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(R.string.car_info_title)
        viewModel.viewState.observe(this) {

        }
        toolbarDecorationConsumer.decorate {
            enableToolbarBackButton(this, viewModel::goBack)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        toolbarDecorationConsumer.decorate(this::disableToolbarBackButton)
    }

    override fun getComponent() = CarInfoComponent.init(carId)
}