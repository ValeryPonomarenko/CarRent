package me.vponomarenko.car.rent.navigator

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import me.vponomarenko.car.rent.R
import me.vponomarenko.car.rent.carinfo.view.CarInfoFragment
import me.vponomarenko.car.rent.carslist.navigation.CarsListViewNavigation
import me.vponomarenko.car.rent.carslist.view.CarsListFragment
import me.vponomarenko.car.rent.common.CommonViewNavigation
import me.vponomarenko.car.rent.map.navigation.MapViewNavigation
import me.vponomarenko.car.rent.map.view.MapFragment
import java.util.concurrent.LinkedBlockingQueue

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class AppNavigator : CommonViewNavigation, MapViewNavigation, CarsListViewNavigation {

    private var activity: AppCompatActivity? = null

    private val fragmentManager: FragmentManager?
        get() = activity?.supportFragmentManager

    private val pendingCommands = LinkedBlockingQueue<FragmentManager.() -> Unit>()

    fun bind(activity: AppCompatActivity) {
        this.activity = activity
        while (pendingCommands.isNotEmpty()) {
            pendingCommands.poll().invoke(activity.supportFragmentManager)
        }
    }

    fun unbind() {
        activity = null
    }

    fun openStartScreen() {
        runCommand {
            beginTransaction()
                .replace(R.id.fragmentContainer, MapFragment())
                .commit()
        }
    }

    private fun runCommand(command: FragmentManager.() -> Unit) {
        fragmentManager?.run(command) ?: pendingCommands.add(command)
    }

    //region CommonViewNavigation impl

    override fun goBack() {
        runCommand(FragmentManager::popBackStack)
    }

    //endregion

    //region MapViewNavigation impl

    override fun openCarsList() {
        runCommand {
            beginTransaction()
                .replace(R.id.fragmentContainer, CarsListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    //endregion

    //region MapViewNavigation + CarsListViewNavigation impl (only openCarsInfo method)

    override fun openCarInfo(carId: String) {
        runCommand {
            beginTransaction()
                .replace(R.id.fragmentContainer, CarInfoFragment.newInstance(carId))
                .addToBackStack(null)
                .commit()
        }
    }

    //endregion
}