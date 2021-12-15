package com.example.u4c1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_event.*

class AddEvent : AppCompatActivity() {

    private var eventsList: MutableList<EventModel> = mutableListOf()
    private lateinit var mAdapter: EventAdapter
    private lateinit var eventHandler: EventHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        eventHandler = EventHandler(this)
        eventsList = eventHandler.getEvents()

        createEvent.setOnClickListener {
            val name = et_name.text.toString()
            val desc = et_desc.text.toString()
            val date = et_date.text.toString()
            val location = et_location.text.toString()
            val price = (et_price.text.toString()).toInt()

            eventHandler.addEvent(name, desc, date, location, price)
            eventsList.clear()
            eventsList.addAll(eventHandler.getEvents())
            mAdapter.notifyDataSetChanged()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("desc", desc)
            intent.putExtra("date", date)
            intent.putExtra("location", location)
            intent.putExtra("price", price)
            startActivity(intent)
        }
    }
}