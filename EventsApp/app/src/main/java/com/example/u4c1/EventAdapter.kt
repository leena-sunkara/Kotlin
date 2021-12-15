package com.example.u4c1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    val context: Context,
    val eventsList: MutableList<EventModel>,
    val listener: OnItemClicked
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventsList[position]
        holder.name.text = event.name
        holder.desc.text = event.desc
        holder.date.text = event.date
        holder.location.text = event.location
        holder.price.text = "₹" + event.price
        holder.edit.setOnClickListener {
            listener.onEditClicked(event)
        }
        holder.delete.setOnClickListener {
            listener.onDeleteClicked(event)
        }
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.event_name)
        var desc: TextView = itemView.findViewById(R.id.event_desc)
        var date: TextView = itemView.findViewById(R.id.event_date)
        var location: TextView = itemView.findViewById(R.id.event_location)
        var price: TextView = itemView.findViewById(R.id.event_price)
        var edit: ImageView = itemView.findViewById(R.id.event_edit)
        var delete: ImageView = itemView.findViewById(R.id.event_delete)
    }
}