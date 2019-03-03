package me.vponomarenko.car.rent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import me.vponomarenko.car.rent.common.ToolbarDecorationConsumer
import me.vponomarenko.car.rent.decorators.ToolbarDecorator
import me.vponomarenko.car.rent.di.AppComponent
import me.vponomarenko.car.rent.navigator.AppNavigator
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToolbarDecorationConsumer {

    @Inject
    internal lateinit var appNavigator: AppNavigator

    @Inject
    internal lateinit var toolbarDecorator: ToolbarDecorator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.findComponent<AppComponent>().inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            appNavigator.openStartScreen()
        }
    }

    override fun onResume() {
        super.onResume()
        appNavigator.bind(this)
        toolbarDecorator.bindToolbar(toolbar)
    }

    override fun onPause() {
        super.onPause()
        appNavigator.unbind()
        toolbarDecorator.unbind()
    }

    override fun decorate(action: Toolbar.() -> Unit) {
        action(toolbar)
    }
}
