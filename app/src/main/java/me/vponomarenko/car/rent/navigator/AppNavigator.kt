package me.vponomarenko.car.rent.navigator

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import me.vponomarenko.car.rent.R
import me.vponomarenko.car.rent.map.view.MapFragment
import java.util.concurrent.LinkedBlockingQueue

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class AppNavigator {

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
}