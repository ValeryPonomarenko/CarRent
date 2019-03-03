package me.vponomarenko.car.rent.carslist.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_car.*
import me.vponomarenko.car.rent.carslist.R
import me.vponomarenko.car.rent.domain.entities.CarInfo

/**
 * Author: Valery Ponomarenko
 * Date: 03/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class CarViewHolder(
    override val containerView: View,
    private val onCarClickListener: (String) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup, onCarClickListener: (String) -> Unit) =
            CarViewHolder(inflater.inflate(R.layout.item_car, parent, false), onCarClickListener)
    }

    fun bind(carInfo: CarInfo) {
        text_modelName.text = carInfo.modelName
        itemView.setOnClickListener {
            onCarClickListener(carInfo.id)
        }
        Glide.with(image_car)
            .load(carInfo.carImageUrl)
            .placeholder(R.drawable.ic_car)
            .into(image_car)
    }
}