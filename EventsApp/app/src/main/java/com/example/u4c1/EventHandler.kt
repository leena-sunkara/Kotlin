package com.example.u4c1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class EventHandler(val context: Context) :
    SQLiteOpenHelper(context, "events_db", null, 1) {

    companion object {
        val TABLE_NAME = "events_table"
        val ID = "id"
        val NAME = "name"
        val DESC = "desc"
        val DATE = "date"
        val LOCATION = "location"
        val PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                "$NAME TEXT, $DESC TEXT, $DATE TEXT, $LOCATION TEXT, $PRICE INTEGER)"
        db?.execSQL(createQuery)
    }

    fun getEvents(): MutableList<EventModel> {
        val eventsList: MutableList<EventModel> = mutableListOf<EventModel>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            do {
                val idIndex = cursor.getColumnIndex(ID)
                val nameIndex = cursor.getColumnIndex(NAME)
                val descIndex = cursor.getColumnIndex(DESC)
                val dateIndex = cursor.getColumnIndex(DATE)
                val locationIndex = cursor.getColumnIndex(LOCATION)
                val priceIndex = cursor.getColumnIndex(PRICE)

                val id: Int = cursor.getInt(idIndex)
                val name: String = cursor.getString(nameIndex)
                val desc: String = cursor.getString(descIndex)
                val date: String = cursor.getString(dateIndex)
                val location: String = cursor.getString(locationIndex)
                val price: Int = cursor.getInt(priceIndex)

                val eventModel = EventModel(id, name, desc, date, location, price)
                eventsList.add(eventModel)
            } while (cursor.moveToNext())
        }
        return eventsList
    }

    fun addEvent(name: String, desc: String, date: String, location: String, price: Int) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(NAME, name)
        values.put(DESC, desc)
        values.put(DATE, date)
        values.put(LOCATION, location)
        values.put(PRICE, price)
        val id = db.insert(TABLE_NAME, null, values)
        if (id.toInt() == -1) {
            Toast.makeText(context, "Error: Event is not registered", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success: Event is registered", Toast.LENGTH_SHORT).show()
        }
    }

    fun editEvent(
        id: Int,
        newName: String,
        newDesc: String,
        newDate: String,
        newLocation: String,
        newPrice: Int
    ) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(ID, id)
        values.put(NAME, newName)
        values.put(DESC, newDesc)
        values.put(DATE, newDate)
        values.put(LOCATION, newLocation)
        values.put(PRICE, newPrice)
        val res = db.update(TABLE_NAME, values, "id = $id", null)
        if (res > 0) {
            Toast.makeText(context, "Success: Event is updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Error: Event is not updated", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteEvent(id: Int) {
        val db = writableDatabase
        val res = db.delete(TABLE_NAME, "id = $id", null)
        if (res > 0) {
            Toast.makeText(context, "Success: Event is deleted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Error: Event is not deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}