package me.vponomarenko.car.rent.carslist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.car.rent.domain.entities.CarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarsListAdapter : RecyclerView.Adapter<CarViewHolder>() {

    var cars: List<CarInfo>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCarClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CarViewHolder.create(LayoutInflater.from(parent.context), parent, this::onCarClick)

    override fun getItemCount() = cars?.size ?: 0

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        cars?.get(position)?.let(holder::bind)
    }

    private fun onCarClick(carId: String) {
        onCarClickListener?.invoke(carId)
    }
}