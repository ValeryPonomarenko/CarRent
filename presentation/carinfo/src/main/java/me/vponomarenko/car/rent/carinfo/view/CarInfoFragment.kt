package me.vponomarenko.car.rent.carinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_car_info.*
import me.vponomarenko.car.rent.carinfo.R
import me.vponomarenko.car.rent.carinfo.di.CarInfoComponent
import me.vponomarenko.car.rent.carinfo.viewmodel.CarInfoViewModel
import me.vponomarenko.car.rent.carinfo.viewstate.CarInfoViewState
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer
import me.vponomarenko.car.rent.common.di.ViewModelFactory
import me.vponomarenko.car.rent.common.disableToolbarBackButton
import me.vponomarenko.car.rent.common.enableToolbarBackButton
import me.vponomarenko.car.rent.common.observe
import me.vponomarenko.car.rent.common.setTitle
import me.vponomarenko.car.rent.common.showToast
import me.vponomarenko.car.rent.domain.entities.FullCarInfo
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
            when (it) {
                is CarInfoViewState.Loaded -> showCarInfo(it.car)
                is CarInfoViewState.Loading -> { /* show loading */ }
                is CarInfoViewState.Error -> showToast(it.error)
            }
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

    private fun showCarInfo(car: FullCarInfo) {
        Glide.with(image_carPhoto)
            .load(car.carImageUrl)
            .placeholder(R.drawable.ic_car_orange)
            .into(image_carPhoto)
        text_carModel.text = car.modelName
        text_name.text = car.name
        text_fuelType.text = car.fuelType.name
        text_fuelLevel.text = car.fuelLevel.toString()
        text_transmission.text = car.transmission.name
        text_licencePlate.text = car.licensePlate
        text_innerCleanliness.text = car.innerCleanliness.name
        view_carColor.setBackgroundColor(car.color)
    }
}