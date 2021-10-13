package com.masai.myjournalapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.myjournalapp.R
import com.masai.myjournalapp.RoutineModel

class RoutineAdapter(
    val context: Context,
    val routineList: MutableList<RoutineModel>,
    val listener: OnTaskItemClicked
) : RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.routine_item_row, parent, false)
        return RoutineViewHolder(view1)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val routine = routineList.get(position)
        holder.title.text = routine.title
        if (routine.title.contains("Meditate")) {
            holder.image.setImageResource(R.drawable.water_art)
        } else if (routine.title.contains("Milk")) {
            holder.image.setImageResource(R.drawable.meditation)
        } else {
            holder.image.setImageResource(R.drawable.friendship)
        }

        holder.edit.setOnClickListener {
            listener.onEditClicked(routine)
        }

        holder.delete.setOnClickListener {
            listener.onDeleteClicked(routine)
        }
    }

    override fun getItemCount(): Int {
        return routineList.size
    }

    class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView
        var edit: ImageView
        var delete: ImageView

        init {
            title = itemView.findViewById(R.id.titleTv)
            image = itemView.findViewById(R.id.img)
            edit = itemView.findViewById(R.id.editIv)
            delete = itemView.findViewById(R.id.deleteIv)
        }
    }
}