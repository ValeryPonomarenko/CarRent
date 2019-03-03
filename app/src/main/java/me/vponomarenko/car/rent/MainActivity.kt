package me.vponomarenko.car.rent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.car.rent.di.AppComponent
import me.vponomarenko.car.rent.navigator.AppNavigator
import me.vponomarenko.injectionmanager.x.XInjectionManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.findComponent<AppComponent>().inject(this)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            appNavigator.openStartScreen()
        }
    }

    override fun onResume() {
        super.onResume()
        appNavigator.bind(this)
    }

    override fun onPause() {
        super.onPause()
        appNavigator.unbind()
    }
}
