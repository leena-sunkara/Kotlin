package com.example.u4c1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClicked {

    private var eventsList: MutableList<EventModel> = mutableListOf()
    private lateinit var mAdapter: EventAdapter
    private lateinit var eventHandler: EventHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventHandler = EventHandler(this)
        eventsList = eventHandler.getEvents()

        mAdapter = EventAdapter(this, eventsList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

        addEvent.setOnClickListener {
            val intent = Intent(this, AddEvent::class.java)
            startActivity(intent)
        }
    }

    override fun onEditClicked(event: EventModel) {
        val intent = Intent(this, EditEvent::class.java)
        intent.putExtra("id", event.id)
        intent.putExtra("name", event.name)
        intent.putExtra("desc", event.desc)
        intent.putExtra("date", event.date)
        intent.putExtra("location", event.location)
        intent.putExtra("price", event.price)
        startActivity(intent)
    }

    override fun onDeleteClicked(event: EventModel) {
        eventHandler.deleteEvent(event.id)
        eventsList.clear()
        eventsList.addAll(eventHandler.getEvents())
        mAdapter.notifyDataSetChanged()
    }
}