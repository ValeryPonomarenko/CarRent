package me.vponomarenko.car.rent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.car.rent.carslist.view.CarsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, CarsListFragment())
                .commit()
        }
    }
}
