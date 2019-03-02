package me.vponomarenko.car.rent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.car.rent.map.view.MapFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, MapFragment())
                .commit()
        }
    }
}
