package me.vponomarenko.car.rent.decorators

import androidx.appcompat.widget.Toolbar
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer
import java.util.concurrent.LinkedBlockingQueue

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ToolbarDecorator : ToolbarDecorationConsumer {

    private var toolbar: Toolbar? = null

    private val pendingActions = LinkedBlockingQueue<Toolbar.() -> Unit>()

    override fun decorate(action: Toolbar.() -> Unit) {
        toolbar?.run(action) ?: pendingActions.add(action)
    }

    fun bindToolbar(toolbar: Toolbar) {
        this.toolbar = toolbar
        while (pendingActions.isNotEmpty()) {
            pendingActions.poll().invoke(toolbar)
        }
    }

    fun unbind() {
        toolbar = null
    }
}