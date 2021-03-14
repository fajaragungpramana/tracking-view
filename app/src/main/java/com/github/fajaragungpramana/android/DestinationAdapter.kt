package com.github.fajaragungpramana.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.fajaragungpramana.trackingview.TrackingView

class DestinationAdapter(private val mListDestination: List<Destination>) :
    RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    override fun getItemCount() = mListDestination.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDestination(mListDestination[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_destination, parent, false)
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mTrackingView by lazy { view.findViewById<TrackingView>(R.id.tkv_destination) }

        private val mPos by lazy { view.findViewById<TextView>(R.id.tv_pos) }
        private val mAddress by lazy { view.findViewById<TextView>(R.id.tv_address) }

        fun bindDestination(destination: Destination) {
            mPos.text = destination.pos
            mAddress.text = destination.address

            mTrackingView.set(adapterPosition, itemCount)
        }

    }

}