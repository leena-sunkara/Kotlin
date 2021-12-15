package com.example.u4c1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_event.*
import kotlinx.android.synthetic.main.activity_add_event.et_date
import kotlinx.android.synthetic.main.activity_add_event.et_desc
import kotlinx.android.synthetic.main.activity_add_event.et_location
import kotlinx.android.synthetic.main.activity_add_event.et_name
import kotlinx.android.synthetic.main.activity_add_event.et_price
import kotlinx.android.synthetic.main.activity_edit_event.*

class EditEvent : AppCompatActivity() {

    private var eventsList: MutableList<EventModel> = mutableListOf()
    private lateinit var mAdapter: EventAdapter
    private lateinit var eventHandler: EventHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        eventHandler = EventHandler(this)
        eventsList = eventHandler.getEvents()

        val id: Int = intent.getIntExtra("id", 0)
        val name: String? = intent.getStringExtra("name")
        val desc: String? = intent.getStringExtra("desc")
        val date: String? = intent.getStringExtra("date")
        val location: String? = intent.getStringExtra("location")
        val price: Int = intent.getIntExtra("price", 0)

        et_name.setText(name)
        et_desc.setText(desc)
        et_date.setText(date)
        et_location.setText(location)
        et_price.setText(price.toString())

        updateEvent.setOnClickListener {
            val name = et_name.text.toString()
            val desc = et_desc.text.toString()
            val date = et_date.text.toString()
            val location = et_location.text.toString()
            val price = (et_price.text.toString()).toInt()

            eventHandler.editEvent(id, name, desc, date, location, price)
            eventsList.clear()
            eventsList.addAll(eventHandler.getEvents())
            mAdapter.notifyDataSetChanged()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}