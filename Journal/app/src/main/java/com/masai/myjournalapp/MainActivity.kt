package com.masai.myjournalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.myjournalapp.adapter.DatabaseHandler
import com.masai.myjournalapp.adapter.OnTaskItemClicked
import com.masai.myjournalapp.adapter.RoutineAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTaskItemClicked {

    private var routineList: MutableList<RoutineModel> = mutableListOf()
    lateinit var mAdapter: RoutineAdapter
    lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)
        routineList = dbHandler.getRoutines()

        mAdapter = RoutineAdapter(this, routineList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter

        addBtn.setOnClickListener {
            dbHandler.insertRoutine("Meditate", "Good for mind and skin", "Tue")
            routineList.clear()
            routineList.addAll(dbHandler.getRoutines())
            mAdapter.notifyDataSetChanged()
        }
    }

    override fun onEditClicked(routine: RoutineModel) {
        dbHandler.updateRoutine(routine.id, "Drink milk", "Good for children", "Mon")
        routineList.clear()
        routineList.addAll(dbHandler.getRoutines())
        mAdapter.notifyDataSetChanged()
    }

    override fun onDeleteClicked(routine: RoutineModel) {
        dbHandler.deleteRoutine(routine.id)
        routineList.clear()
        routineList.addAll(dbHandler.getRoutines())
        mAdapter.notifyDataSetChanged()
    }
}