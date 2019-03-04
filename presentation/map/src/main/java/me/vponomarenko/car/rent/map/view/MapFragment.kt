package me.vponomarenko.car.rent.map.view

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_map.*
import me.vponomarenko.car.rent.common.di.ViewModelFactory
import me.vponomarenko.car.rent.common.observe
import me.vponomarenko.car.rent.common.setTitle
import me.vponomarenko.car.rent.common.showToast
import me.vponomarenko.car.rent.domain.entities.CarInfo
import me.vponomarenko.car.rent.map.R
import me.vponomarenko.car.rent.map.di.MapComponent
import me.vponomarenko.car.rent.map.utils.GeoPointMapper
import me.vponomarenko.car.rent.map.utils.MapIconFactory
import me.vponomarenko.car.rent.map.viewmodel.MapViewModel
import me.vponomarenko.car.rent.map.viewstate.MapViewState
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MapFragment : Fragment(), IHasComponent<MapComponent> {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var geoPointMapper: GeoPointMapper

    @Inject
    internal lateinit var mapIconFactory: MapIconFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MapViewModel::class.java)
    }

    private val mapController: IMapController
        get() = map.controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.bindComponent(this).inject(this)
        setHasOptionsMenu(true)
        Configuration
            .getInstance()
            .load(requireContext(), PreferenceManager.getDefaultSharedPreferences(requireContext()));
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_map, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(R.string.map_title)
        map.setTileSource(TileSourceFactory.MAPNIK)
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is MapViewState.Loaded -> drawCars(it.cars)
                is MapViewState.Loading -> { /* show loading */ }
                is MapViewState.Error -> showToast(it.error)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_map, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            me.vponomarenko.car.rent.map.R.id.option_as_list -> {
                viewModel.onCarsListClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun getComponent() = MapComponent.init()

    private fun drawCars(cars: List<CarInfo>) {
        if (cars.isEmpty()) return
        centerMap(geoPointMapper.map(cars[0].latitude, cars[0].longitude))

        val overlay = ItemizedOverlayWithFocus<OverlayItem>(
            requireContext(),
            cars.map(mapIconFactory::create),
            object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
                override fun onItemSingleTapUp(index: Int, item: OverlayItem): Boolean {
                    return false
                }

                override fun onItemLongPress(index: Int, item: OverlayItem): Boolean {
                    viewModel.onCarClicked(item.uid)
                    return true
                }
            }
        )
        overlay.setFocusItemsOnTap(true)
        map.overlays.add(overlay)
    }

    private fun centerMap(geoPoint: GeoPoint) {
        mapController.setZoom(12.0)
        mapController.setCenter(geoPoint)
    }
}